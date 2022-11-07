package com.ras.persona.usecase.boundary.converter

import com.ras.persona.domain.commons.Email
import com.ras.persona.domain.persona.Persona
import com.ras.persona.domain.persona.PersonaId
import com.ras.persona.domain.persona.UserId
import com.ras.persona.domain.persona.data.Bio
import com.ras.persona.domain.persona.data.Contact
import com.ras.persona.domain.persona.data.Data
import com.ras.persona.domain.persona.data.DataType
import com.ras.persona.usecase.boundary.data.commons.DataOfPersonaDataIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn
import com.ras.persona.usecase.boundary.data.output.PersonaDataOut

fun Persona.toOut(): PersonaDataOut {
    val dataMap: MutableMap<String, DataOfPersonaDataIn> = mutableMapOf()

    this.data.forEach {
        when (val item: Data = it.value) {
            is Bio -> dataMap[it.key.name] = item.toDataIn()
            is Contact -> dataMap[it.key.name] = item.toDataIn()
        }
    }

    return PersonaDataOut(
            this.id.value,
            this.userId.value,
            this.name,
            this.email.value,
            dataMap
        )
}

fun PersonaDataOut.toPersona(): Persona {

    val persona = Persona(PersonaId(id), UserId(userId), name, Email(email))

    val listData: List<Data> = data.mapNotNull {
        dataPersonaToDomain(DataType.valueOf(it.key), it.value)
    }

    listData.forEach { persona.addData(it) }

    return persona
}

fun PersonaDataOut.toPersonaIn(): PersonaDataIn =
    PersonaDataIn(
        this.id,
        this.name,
        this.email,
        this.data
    )
