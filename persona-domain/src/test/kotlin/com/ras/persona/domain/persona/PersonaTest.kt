package com.ras.persona.domain.persona

import com.ras.persona.domain.commons.Email
import com.ras.persona.domain.commons.Height
import com.ras.persona.domain.commons.Weight
import com.ras.persona.domain.persona.data.Bio
import com.ras.persona.domain.persona.data.Contact
import org.junit.jupiter.api.Assertions.*
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
    fun `create data type contact for persona`() {
        val persona = Persona(PersonaId("1"), "R", Email("teste"))

        val phone = "9999-9999"
        val contact = Contact(phone)
        persona.addData(contact)

        assertEquals(persona.data.size, 1)
        assertTrue(persona.data.containsValue(contact))


        val personaContact: Contact = (persona.data[contact.type] ?: throw NullPointerException()) as Contact
        assertEquals(personaContact.mainPhone, phone)
    }

    @Test
    fun `create data type bio for persona`() {
        val persona = Persona(PersonaId("1"), "R", Email("teste"))

        val bio = Bio(Weight(99.9), Height(1.73, "mt"))
        persona.addData(bio)

        assertEquals(persona.data.size, 1)
        assertTrue(persona.data.containsValue(bio))

        val personaBio: Bio = (persona.data[bio.type] ?: throw NullPointerException()) as Bio
        assertEquals(personaBio.weight.kg, 99.9)
        assertEquals(personaBio.height.cm, 173)
    }
}
