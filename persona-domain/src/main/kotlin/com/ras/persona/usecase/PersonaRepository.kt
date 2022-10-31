package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.data.output.PersonaDataOut

interface PersonaRepository {

    fun findById(id: String): PersonaDataOut

    fun save(persona: PersonaDataOut)

    fun isExistingEmail(email: String): Boolean
}