package com.ras.persona.domain.persona

import com.ras.persona.commons.Email
import com.ras.persona.domain.figure.FigureData
import com.ras.persona.domain.figure.FigureType

class Persona(
    val id: PersonaId,
    val name: String,
    val email: Email
) {
    private val figures: MutableList<FigureData<Any>> = mutableListOf()

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }

    fun createFigure(figure: FigureData<Any>) {
        if (figures.any { it.type == figure.type })
            throw IllegalArgumentException("figure already exist")

        figures.add(figure)
    }

    fun findFigure(type: FigureType): FigureData<Any>? {
        return figures.firstOrNull { it.type == type }
    }
}
