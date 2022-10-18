package com.ras.persona.domain.persona

import com.ras.persona.commons.Email
import com.ras.persona.domain.data.Bio
import com.ras.persona.domain.data.Contact
import com.ras.persona.domain.figure.FigureDataBio
import com.ras.persona.domain.figure.FigureDataContact
import com.ras.persona.domain.figure.FigureId
import com.ras.persona.domain.figure.FigureType
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
        val personaId = PersonaId("123")
        val persona = Persona(personaId, "R", Email("teste@teste.com"))

        assertNotNull(persona)
        assertEquals(persona.id, personaId)
    }

    @Test
    fun `dont build persona with empty name`() {
        assertThrows<IllegalArgumentException> { Persona(PersonaId("123"), "", Email("teste@teste.com")) }
    }

    @Test
    fun `create figure for persona`() {
        val persona = Persona(PersonaId("1"), "R", Email("teste"))

        val contact = Contact("9999-9999")
        val figureContact = FigureDataContact(FigureId("1"), contact)

        val bio = Bio(weight = 99.9, heightCm = 173, shoeSize = 41)
        val figureBio = FigureDataBio(FigureId("2"), bio)

        persona.createFigure(figureContact)
        persona.createFigure(figureBio)

        val resultContact = persona.findFigure(FigureType.CONTACT) as FigureDataContact
        assertNotNull(resultContact)
        assertEquals(resultContact.data, contact)

        val resultBio = persona.findFigure(FigureType.BIO) as FigureDataBio
        assertNotNull(resultBio)
        assertEquals(resultBio.data, bio)
    }

    @Test
    fun `do not create an existing figure for a persona`() {
        val persona = Persona(PersonaId("1"), "R", Email("teste"))

        val contact = Contact("9999-9999")
        val figure = FigureDataContact(FigureId("2"), contact)

        persona.createFigure(figure)

        assertThrows<IllegalArgumentException> { persona.createFigure(figure) }
    }
}
