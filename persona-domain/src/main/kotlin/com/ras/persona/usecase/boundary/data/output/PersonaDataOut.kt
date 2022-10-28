package com.ras.persona.usecase.boundary.data.output

data class PersonaDataOut(
    val id: String,
    val name: String,
    val email: String,
    val data: Map<String, Any>
)
