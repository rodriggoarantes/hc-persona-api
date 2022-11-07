package com.ras.persona.config.exception

import java.time.LocalDateTime

data class ErrorResponse(
    val code: Int,
    val error: String,
    val time: LocalDateTime = LocalDateTime.now()
)
