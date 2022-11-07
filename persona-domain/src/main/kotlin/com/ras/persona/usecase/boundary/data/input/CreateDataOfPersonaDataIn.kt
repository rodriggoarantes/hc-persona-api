package com.ras.persona.usecase.boundary.data.input

import com.ras.persona.domain.persona.data.DataType

data class CreateDataOfPersonaDataIn<T>(
    val personaId: String,
    val dataType: DataType,
    val data: T
)
