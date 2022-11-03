package com.ras.persona.resource

import com.ras.persona.commons.Loggable
import com.ras.persona.usecase.CreatePersonaUseCase
import com.ras.persona.usecase.boundary.data.input.CreatePersonaDataIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    path = ["/personas"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
class PersonaResource(
    private val createPersonaUseCase: CreatePersonaUseCase
) : Loggable {

    @PostMapping
    fun create(@RequestBody dataIn: CreatePersonaDataIn): ResponseEntity<PersonaDataIn> {
        logger.info("PersonaResource :: create")

        val personaDataIn = createPersonaUseCase.execute(dataIn)

        return ResponseEntity.ok(personaDataIn)
    }
}
