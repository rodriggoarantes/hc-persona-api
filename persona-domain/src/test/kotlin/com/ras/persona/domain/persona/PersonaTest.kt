package com.ras.persona.domain.persona

import com.ras.persona.commons.Email
import com.ras.persona.commons.Height
import com.ras.persona.commons.Weight
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PersonaTest {

    @Test
    fun `build email`() {
        val value = "teste@teste.com"
        val email = Email(value)
        assertEquals(email.value, value)
    }

    @Test
    fun `dont build email with empty value`() {
        assertThrows<IllegalArgumentException> { Email("") }
    }

    @Test
    fun `build persona`() {
        val value = "teste@teste.com"
        val email = Email(value)

        val personaId = PersonaId("123")

        val persona = Persona(personaId, name="R", email)

        assertNotNull(persona)
        assertEquals(persona.id, personaId)
        assertEquals(persona.name, "R")
        assertEquals(persona.email, email)
    }

    @Test
    fun `dont build persona with empty name`() {
        assertThrows<IllegalArgumentException> { Persona(PersonaId("123"), "", Email("teste@teste.com")) }
    }

    @Test
    fun `create contact for persona`() {
        val persona = Persona(PersonaId("1"), "R", Email("teste"))

        val contact = Contact("9999-9999")
        persona.saveContact(contact)

        assertNotNull(persona.contact)
        assertEquals(persona.contact, contact)
    }

    @Test
    fun `create bio for persona`() {
        val persona = Persona(PersonaId("1"), "R", Email("teste"))

        val bio = Bio(Weight(99.9), Height(1.73, "mt"))
        persona.saveBio(bio)

        assertNotNull(persona.bio)
        assertEquals(persona.bio, bio)

        val personaBio: Bio = persona.bio ?: throw NullPointerException()
        assertEquals(personaBio.weight.kg, 99.9)
        assertEquals(personaBio.height.cm, 173)
    }
}
