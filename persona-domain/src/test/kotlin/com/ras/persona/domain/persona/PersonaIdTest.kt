package com.ras.persona.domain.persona

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

internal class PersonaIdTest {

    @Test
    fun `build PersonaId`() {
        val value = UUID.randomUUID().toString()
        val id = PersonaId(value)

        Assertions.assertEquals(id.value, value)
        Assertions.assertEquals(id.toString(), value)
    }

    @Test
    fun `dont build PersonaId with empty value`() {
        assertThrows<IllegalArgumentException> { PersonaId("") }
    }

    @Test
    fun `dont build PersonaId with invalid uuid value`() {
        assertThrows<IllegalArgumentException> { PersonaId("invalid-uuid-123") }
    }
    
}