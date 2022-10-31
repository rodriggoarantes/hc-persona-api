package com.ras.persona.domain.commons

data class Height(private val value: Double, private val system: String = "cm") {
    val cm: Int = when (system) {
        "cm" -> value.toInt()
        "mt" -> (value * 100).toInt()
        "mi" -> (value * 160900).toInt()
        "ft" -> (value * 30.48).toInt()
        else -> { throw IllegalArgumentException("measurement system is unknown") }
    }
}
