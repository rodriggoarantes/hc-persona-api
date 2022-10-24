package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.output.PersonaDataOut

interface PersonaRepository {

    fun save(persona: PersonaDataOut)

    fun isExistingEmail(email: String): Boolean
}