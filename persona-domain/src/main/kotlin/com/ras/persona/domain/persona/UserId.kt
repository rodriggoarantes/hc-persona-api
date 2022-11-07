package com.ras.persona.domain.persona

data class UserId(val value: String) {
    init {
        require(value.isNotBlank()) { "value cannot be blank" }
    }

    override fun toString(): String {
        return value
    }
}
