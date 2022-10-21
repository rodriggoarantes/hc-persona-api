package com.ras.persona.usecase.boundary.converter

import com.ras.persona.domain.persona.Persona
import com.ras.persona.domain.persona.data.Bio
import com.ras.persona.domain.persona.data.Contact
import com.ras.persona.domain.persona.data.Data
import com.ras.persona.usecase.boundary.output.BioOut
import com.ras.persona.usecase.boundary.output.ContactOut
import com.ras.persona.usecase.boundary.output.PersonaOut

fun Persona.toOut(): PersonaOut {
    val dataMap: Map<String, Any> = mutableMapOf()

    this.data.mapNotNull {
        when(val item: Data = it.value) {
            is Bio -> BioOut(item.weight.kg, item.height.cm)
            is Contact -> ContactOut(item.mainPhone)
            else -> { it.value }
        }
    }

    return PersonaOut(
            this.id.value,
            this.name,
            this.email.value,
            dataMap
        )
}
