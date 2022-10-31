package com.ras.persona.domain.commons

data class Weight(private val value: Double, private val systemWeight: String = "kg") {
    init {
        require(value > 0) { "value cannot be zero" }
        require(systemWeight.isNotBlank()) { "systemWeight cannot be blank" }
    }

    val kg: Double = when (systemWeight) {
        "kg" -> value
        "lb" -> value / 2.205
        "gr" -> value / 1000
        "oz" -> value / 35.274
        else -> { throw IllegalArgumentException("measurement system is unknown") }
    }
}
