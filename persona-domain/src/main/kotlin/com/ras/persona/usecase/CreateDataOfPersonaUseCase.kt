package com.ras.persona.usecase

import com.ras.persona.usecase.boundary.data.commons.DataOfPersonaDataIn
import com.ras.persona.usecase.boundary.data.input.CreateDataOfPersonaDataIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn

interface CreateDataOfPersonaUseCase {
    fun execute(input: CreateDataOfPersonaDataIn<DataOfPersonaDataIn>): PersonaDataIn
}