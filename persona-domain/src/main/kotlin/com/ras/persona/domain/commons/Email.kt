package com.ras.persona.domain.commons

data class Email(val value: String) {
    init {
        require(value.isNotBlank()) { "E-mail value cannot be blank" }
    }

    override fun toString(): String {
        return value
    }
}
