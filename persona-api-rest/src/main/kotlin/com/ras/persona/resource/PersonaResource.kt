package com.ras.persona.resource

import com.fasterxml.jackson.databind.ObjectMapper
import com.ras.persona.commons.Loggable
import com.ras.persona.config.context.ContextStore
import com.ras.persona.domain.exception.UnauthorizedException
import com.ras.persona.domain.persona.data.DataType
import com.ras.persona.resource.dto.CreateDataOfPersonaDto
import com.ras.persona.usecase.CreateDataOfPersonaUseCase
import com.ras.persona.usecase.CreatePersonaUseCase
import com.ras.persona.usecase.FindPersonaByIdUseCase
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
    private val contextStore: ContextStore,
    private val objectMapper: ObjectMapper,
    private val createPersonaUseCase: CreatePersonaUseCase,
    private val createDataOfPersonaUseCase: CreateDataOfPersonaUseCase,
    private val getPersonaByIdUseCase: FindPersonaByIdUseCase
) : Loggable {

    @PostMapping
    fun create(@RequestBody dataIn: CreatePersonaDataIn): ResponseEntity<PersonaDataIn> {
        logger.info("PersonaResource :: create")

        if (contextStore.userId != dataIn.userId)
            throw UnauthorizedException()

        val personaDataIn = createPersonaUseCase.execute(dataIn)

        return ResponseEntity.ok(personaDataIn)
    }

    @PostMapping("/data/{dataType}")
    fun createDataByType(
        @PathVariable dataType: DataType,
        @RequestBody dto: CreateDataOfPersonaDto
    ): ResponseEntity<Void> {

        logger.info("PersonaResource :: createDataByType")

        val dataJsonValue = dto.data.toString()

        val dataOfPersona: DataOfPersonaDataIn = when (dataType) {
            DataType.CONTACT -> objectMapper.readValue(dataJsonValue, ContactData::class.java)
            DataType.BIO -> objectMapper.readValue(dataJsonValue, BioData::class.java)
            else -> { throw IllegalArgumentException("Tipo de dados é desconhecido") }
        }

        val input = CreateDataOfPersonaDataIn(dto.personaId, contextStore.userId, dataType, dataOfPersona)

        createDataOfPersonaUseCase.execute(input)

        return ResponseEntity.created(URI.create("/personas/${dto.personaId}")).build()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<PersonaDataIn> {
        logger.info("PersonaResource :: getById")

        val personaDataIn = getPersonaByIdUseCase.execute(id)

        return ResponseEntity.ok(personaDataIn)
    }
}
