package com.ras.persona.usecase.boundary.input

data class PersonaDataIn(
    val id: String,
    val name: String,
    val email: String,
    val data: Map<String, Any>
)
