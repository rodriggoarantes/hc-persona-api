package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.input.PersonaIn

interface CreatePersonaUseCase {
    fun execute(input: PersonaIn)
}