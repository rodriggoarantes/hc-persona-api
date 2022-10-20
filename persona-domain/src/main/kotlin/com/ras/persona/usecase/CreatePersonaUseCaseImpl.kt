package com.ras.persona.usecase

import com.ras.persona.commons.Email
import com.ras.persona.domain.persona.Persona
import com.ras.persona.domain.persona.PersonaId
import com.ras.persona.usecase.boundary.converter.personaToOut
import com.ras.persona.usecase.boundary.input.PersonaIn
import com.ras.persona.usecase.boundary.output.PersonaOut

class CreatePersonaUseCaseImpl(private val personaRepository: PersonaRepository): CreatePersonaUseCase {

    override fun execute(input: PersonaIn) {
        val id: PersonaId = PersonaId.generate()

        val persona = Persona(id, input.name, Email(input.email))

        val out: PersonaOut = personaToOut(persona)

        personaRepository.save(out)
    }
}