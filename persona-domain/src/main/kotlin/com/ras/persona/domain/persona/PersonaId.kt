package com.ras.persona.domain.persona

data class PersonaId(val value: String) {
    init {
        require(value.isNotBlank()) { "value cannot be blank" }
    }
}
