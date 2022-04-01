package com.ras.persona.commons

data class Email(val value: String) {
    init {
        require(value.isNotBlank()) { "E-mail value cannot be blank" }
    }
}
