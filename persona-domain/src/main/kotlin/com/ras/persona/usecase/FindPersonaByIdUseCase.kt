package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.data.input.PersonaDataIn

interface FindPersonaByIdUseCase {
    fun execute(personaId: String): PersonaDataIn
}