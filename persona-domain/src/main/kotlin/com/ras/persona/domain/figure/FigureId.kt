package com.ras.persona.domain.figure

data class FigureId(val value: String) {
    init {
        require(value.isNotBlank()) { "value cannot be blank" }
    }
}
