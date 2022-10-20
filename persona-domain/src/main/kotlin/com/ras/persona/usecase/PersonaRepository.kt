package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.output.PersonaOut

interface PersonaRepository {

    fun save(persona: PersonaOut)
}