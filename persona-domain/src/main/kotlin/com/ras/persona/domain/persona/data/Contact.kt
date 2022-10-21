package com.ras.persona.domain.persona.data

data class Contact(val mainPhone: String) : Data(DataType.CONTACT) {
    init {
        require(mainPhone.isNotBlank()) { "mainPhone cannot be blank" }
    }
}
