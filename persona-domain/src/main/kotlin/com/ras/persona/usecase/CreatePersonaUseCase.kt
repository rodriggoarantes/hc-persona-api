package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.input.CreatePersonaDataIn
import com.ras.persona.usecase.boundary.input.PersonaDataIn

interface CreatePersonaUseCase {
    fun execute(input: CreatePersonaDataIn): PersonaDataIn
}