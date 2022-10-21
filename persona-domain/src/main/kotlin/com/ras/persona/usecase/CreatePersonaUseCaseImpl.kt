package com.ras.persona.usecase

import com.ras.persona.commons.Email
import com.ras.persona.domain.persona.Persona
import com.ras.persona.domain.persona.PersonaId
import com.ras.persona.usecase.boundary.converter.toOut
import com.ras.persona.usecase.boundary.input.PersonaIn

class CreatePersonaUseCaseImpl(private val personaRepository: PersonaRepository): CreatePersonaUseCase {

    override fun execute(input: PersonaIn) {

        // TODO verificar email existente

        val id: PersonaId = PersonaId.generate()

        val persona = Persona(id, input.name, Email(input.email))

        personaRepository.save(persona.toOut())
    }
}