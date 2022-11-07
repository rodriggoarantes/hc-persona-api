package com.ras.persona.usecase.boundary.data.output

import com.ras.persona.usecase.boundary.data.commons.DataOfPersonaDataIn

data class PersonaDataOut(
    val id: String,
    val userId: String,
    val name: String,
    val email: String,
    val data: Map<String, DataOfPersonaDataIn>
)
