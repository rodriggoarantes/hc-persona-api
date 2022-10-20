package com.ras.persona.domain.persona

import com.ras.persona.commons.Email

class Persona(
    val id: PersonaId,
    val name: String,
    val email: Email
) {
    var contact: Contact? = null
        private set
    var bio: Bio? = null
        private set

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }

    fun saveContact(contact: Contact) {
        this.contact = contact
    }

    fun saveBio(bio: Bio) {
        this.bio = bio
    }
}
