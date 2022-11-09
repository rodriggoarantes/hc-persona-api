package com.ras.persona.domain.persona

import java.util.UUID

data class PersonaId(val value: String) {
    init {
        require(value.isNotBlank()) { "Id de persona não pode ser vazio" }
        require(runCatching { UUID.fromString(value) }.isSuccess) { "O Identificador deve ser um UUID valido" }
    }

    companion object {
        fun generate() : PersonaId = PersonaId(UUID.randomUUID().toString())
    }

    override fun toString(): String {
        return value
    }
}
