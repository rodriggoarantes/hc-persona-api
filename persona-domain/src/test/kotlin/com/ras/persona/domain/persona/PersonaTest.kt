package com.ras.persona.domain.persona

import com.ras.persona.commons.Email
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class PersonaTest {

    @Test
    fun `build persona`() {

        val personaId = PersonaId("123")
        val persona = Persona(personaId, "R", Email("teste@teste.com"))

        assertNotNull(persona)
    }
}
