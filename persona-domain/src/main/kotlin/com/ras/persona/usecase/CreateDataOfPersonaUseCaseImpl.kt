package com.ras.persona.usecase

import com.ras.persona.domain.exception.UnauthorizedException
import com.ras.persona.usecase.boundary.converter.personaDataInToDomain
import com.ras.persona.usecase.boundary.converter.toOut
import com.ras.persona.usecase.boundary.converter.toPersona
import com.ras.persona.usecase.boundary.converter.toPersonaIn
import com.ras.persona.usecase.boundary.data.commons.DataOfPersonaDataIn
import com.ras.persona.usecase.boundary.data.input.CreateDataOfPersonaDataIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn

class CreateDataOfPersonaUseCaseImpl(private val personaRepository: PersonaRepository): CreateDataOfPersonaUseCase {

    override fun execute(input: CreateDataOfPersonaDataIn<DataOfPersonaDataIn>): PersonaDataIn {

        val persona = personaRepository.findById(input.personaId).toPersona()

        if (input.userId != persona.userId.value)
            throw UnauthorizedException()

        val dataPersona = personaDataInToDomain(input.dataType, input.data)
        persona.addData(dataPersona)

        val personaOut = persona.toOut()
        personaRepository.save(personaOut)

        return personaOut.toPersonaIn()
    }

}