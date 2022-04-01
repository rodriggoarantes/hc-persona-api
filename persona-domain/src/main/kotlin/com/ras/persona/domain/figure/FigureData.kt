package com.ras.persona.domain.figure

abstract class FigureData<out T>(
    val id: FigureId,
    val type: FigureType,
    val data: T
)
