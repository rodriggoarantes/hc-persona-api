package com.ras.persona.usecase.boundary.output

data class ContactOut(
    val mainPhone: String
)

data class BioOut(
    val weightKg: Double,
    val heightCm: Int
)

data class PersonaOut(
    val id: String,
    val name: String,
    val email: String,
    val data: Map<String, Any>
)
