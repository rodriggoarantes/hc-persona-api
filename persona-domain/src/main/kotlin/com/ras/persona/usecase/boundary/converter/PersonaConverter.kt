package com.ras.persona.usecase.boundary.converter

import com.ras.persona.domain.persona.Persona
import com.ras.persona.usecase.boundary.output.BioOut
import com.ras.persona.usecase.boundary.output.ContactOut
import com.ras.persona.usecase.boundary.output.PersonaOut

fun personaToOut(persona : Persona): PersonaOut {
    println("[DEBUG] TESTE")
    return PersonaOut("", "", "", ContactOut(""), BioOut(99.9, 173))
}
