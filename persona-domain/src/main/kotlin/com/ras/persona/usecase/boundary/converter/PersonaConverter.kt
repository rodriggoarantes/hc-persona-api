package com.ras.persona.usecase.boundary.converter

import com.ras.persona.domain.persona.Persona
import com.ras.persona.domain.persona.data.Bio
import com.ras.persona.domain.persona.data.Contact
import com.ras.persona.domain.persona.data.Data
import com.ras.persona.usecase.boundary.commons.BioData
import com.ras.persona.usecase.boundary.commons.ContactData
import com.ras.persona.usecase.boundary.input.PersonaDataIn
import com.ras.persona.usecase.boundary.output.PersonaDataOut

fun Persona.toOut(): PersonaDataOut {
    val dataMap: Map<String, Any> = mutableMapOf()

    this.data.mapNotNull {
        when(val item: Data = it.value) {
            is Bio -> BioData(item.weight.kg, item.height.cm)
            is Contact -> ContactData(item.mainPhone)
            else -> { it.value }
        }
    }

    return PersonaDataOut(
            this.id.value,
            this.name,
            this.email.value,
            dataMap
        )
}

fun PersonaDataOut.toPersonaIn(): PersonaDataIn {
    return PersonaDataIn(
        this.id,
        this.name,
        this.email,
        this.data
    )
}
