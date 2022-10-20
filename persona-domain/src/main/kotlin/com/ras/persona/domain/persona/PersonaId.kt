package com.ras.persona.domain.persona

import java.util.UUID

data class PersonaId(val value: String) {
    init {
        require(value.isNotBlank()) { "value cannot be blank" }
    }

    companion object {
        fun generate() : PersonaId = PersonaId(UUID.randomUUID().toString())
    }
}
