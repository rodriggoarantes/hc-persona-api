package com.ras.persona.usecase

import com.ras.persona.domain.commons.Email
import com.ras.persona.domain.persona.Persona
import com.ras.persona.domain.persona.PersonaId
import com.ras.persona.domain.persona.exception.EmailAlreadyExistsException
import com.ras.persona.usecase.boundary.converter.toOut
import com.ras.persona.usecase.boundary.converter.toPersonaIn
import com.ras.persona.usecase.boundary.data.input.CreatePersonaDataIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn

class CreatePersonaUseCaseImpl(private val personaRepository: PersonaRepository): CreatePersonaUseCase {

    override fun execute(input: CreatePersonaDataIn): PersonaDataIn {

        val isExistingEmail = personaRepository.isExistingEmail(input.email)
        if (isExistingEmail) throw EmailAlreadyExistsException(input.email)

        val persona = Persona(PersonaId.generate(), input.name, Email(input.email))

        val personaOut = persona.toOut()
        personaRepository.save(personaOut)

        return personaOut.toPersonaIn()
    }
}