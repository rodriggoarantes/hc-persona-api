package com.ras.persona.resource

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.ras.persona.commons.Loggable
import com.ras.persona.domain.persona.data.DataType
import com.ras.persona.usecase.CreateDataOfPersonaUseCase
import com.ras.persona.usecase.CreatePersonaUseCase
import com.ras.persona.usecase.boundary.data.commons.BioData
import com.ras.persona.usecase.boundary.data.commons.ContactData
import com.ras.persona.usecase.boundary.data.commons.DataOfPersonaDataIn
import com.ras.persona.usecase.boundary.data.input.CreateDataOfPersonaDataIn
import com.ras.persona.usecase.boundary.data.input.CreatePersonaDataIn
import com.ras.persona.usecase.boundary.data.input.PersonaDataIn
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(
    path = ["/personas"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
class PersonaResource(
    private val objectMapper: ObjectMapper,
    private val createPersonaUseCase: CreatePersonaUseCase,
    private val createDataOfPersonaUseCase: CreateDataOfPersonaUseCase
) : Loggable {

    @PostMapping
    fun create(@RequestBody dataIn: CreatePersonaDataIn): ResponseEntity<PersonaDataIn> {
        logger.info("PersonaResource :: create")

        val personaDataIn = createPersonaUseCase.execute(dataIn)

        return ResponseEntity.ok(personaDataIn)
    }

    @PostMapping("/data/{dataType}")
    fun createDataByType(
        @PathVariable dataType: DataType,
        @RequestBody dataIn: CreateDataOfPersonaDataIn<JsonNode>
    ): ResponseEntity<Void> {

        logger.info("PersonaResource :: createDataByType")

        val dataJsonValue = dataIn.data.toString()

        val dataOfPersona: DataOfPersonaDataIn = when (dataType) {
            DataType.CONTACT -> objectMapper.readValue(dataJsonValue, ContactData::class.java)
            DataType.BIO -> objectMapper.readValue(dataJsonValue, BioData::class.java)
            else -> { throw IllegalArgumentException("Tipo de dados é desconhecido") }
        }

        val input = CreateDataOfPersonaDataIn(dataIn.personaId, dataType, dataOfPersona)

        createDataOfPersonaUseCase.execute(input)

        return ResponseEntity.created(URI.create("/personas/${dataIn.personaId}")).build()
    }
}
