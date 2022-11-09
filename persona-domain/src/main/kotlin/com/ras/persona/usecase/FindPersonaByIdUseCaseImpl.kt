package com.ras.persona.usecase

import com.ras.persona.domain.persona.PersonaId
import com.ras.persona.usecase.boundary.converter.toPersonaIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn

class FindPersonaByIdUseCaseImpl(private val personaRepository: PersonaRepository): FindPersonaByIdUseCase {

    override fun execute(personaId: String): PersonaDataIn {

        val id = PersonaId(personaId)

        val personaOut = personaRepository.findById(id.value)

        return personaOut.toPersonaIn()
    }


}