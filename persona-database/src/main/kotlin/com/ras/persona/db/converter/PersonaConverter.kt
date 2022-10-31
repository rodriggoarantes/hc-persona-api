package com.ras.persona.db.converter

import com.ras.persona.db.entity.PersonaEntity
import com.ras.persona.usecase.boundary.data.output.PersonaDataOut

fun PersonaDataOut.toEntity() = PersonaEntity(id, name, email, data)

fun PersonaEntity.toDataOut() = PersonaDataOut(id, name, email, data)