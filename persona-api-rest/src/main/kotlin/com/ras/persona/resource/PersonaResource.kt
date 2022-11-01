package com.ras.persona.resource

import com.ras.persona.commons.Loggable
import com.ras.persona.usecase.PersonaRepository
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn
import com.ras.persona.usecase.boundary.data.output.PersonaDataOut
import org.springframework.boot.info.BuildProperties
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(
    path = ["/personas"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
class PersonaResource(
    private val personaRepository: PersonaRepository
) : Loggable {

    @PostMapping("/input")
    fun inpuptTest(): ResponseEntity<PersonaDataOut> {
        logger.info("PersonaResource")

        val id = UUID.randomUUID().toString()

        val persona = PersonaDataOut(
            id, "nome", "email@email.com", mapOf()
        )

        personaRepository.save(persona)

        return ResponseEntity.ok(persona)
    }
}
