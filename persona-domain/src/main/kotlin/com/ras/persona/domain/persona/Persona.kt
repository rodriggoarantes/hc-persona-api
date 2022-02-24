package com.ras.persona.domain.persona

import com.ras.persona.commons.Email

class Persona(
    private val id: PersonaId,
    private val name: String,
    private val email: Email
)
