package com.ras.persona.domain.persona

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

internal class UserIdTest {

    @Test
    fun `build user id`() {
        val value = UUID.randomUUID().toString()
        val id = UserId(value)
        Assertions.assertEquals(id.value, value)
    }

    @Test
    fun `dont build UserId with empty value`() {
        assertThrows<IllegalArgumentException> { UserId("") }
    }
    
}