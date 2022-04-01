package com.ras.persona.domain.data

data class Contact(val mainPhone: String) {
    init {
        require(mainPhone.isNotBlank()) { "mainPhone cannot be blank" }
    }
}
