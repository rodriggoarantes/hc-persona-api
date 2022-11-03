package com.ras.persona.config.exception

import java.time.LocalDateTime

data class Error(
    val code: Int,
    val error: String,
    val time: LocalDateTime = LocalDateTime.now()
)
