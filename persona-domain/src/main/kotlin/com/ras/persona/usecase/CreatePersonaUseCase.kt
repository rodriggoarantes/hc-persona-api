package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.`in`.PersonaInput

interface CreatePersonaUseCase {
    fun execute(input: PersonaInput)
}