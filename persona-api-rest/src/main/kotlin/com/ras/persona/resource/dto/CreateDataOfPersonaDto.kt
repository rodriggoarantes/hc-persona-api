package com.ras.persona.resource.dto

import com.fasterxml.jackson.databind.JsonNode

data class CreateDataOfPersonaDto(
    val personaId: String,
    val data: JsonNode
)
