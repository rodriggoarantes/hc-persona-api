package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.data.input.CreatePersonaDataIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn

interface CreatePersonaUseCase {
    fun execute(input: CreatePersonaDataIn): PersonaDataIn
}