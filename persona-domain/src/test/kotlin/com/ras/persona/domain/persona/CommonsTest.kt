package com.ras.persona.domain.persona

import com.ras.persona.domain.commons.Email
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CommonsTest {

    @Test
    fun `build email`() {
        val value = "teste@teste.com"
        val email = Email(value)
        Assertions.assertEquals(email.value, value)
    }

    @Test
    fun `dont build email with empty value`() {
        assertThrows<IllegalArgumentException> { Email("") }
    }

}