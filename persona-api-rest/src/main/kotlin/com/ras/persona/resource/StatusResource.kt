package com.ras.persona.resource

import com.ras.persona.commons.Loggable
import com.ras.persona.config.context.ContextStore
import com.ras.persona.usecase.boundary.data.output.PersonaDataOut
import org.springframework.boot.info.BuildProperties
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    path = ["/status"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
class StatusResource(
    private val buildProperties: BuildProperties,
    private val contextStore: ContextStore
) : Loggable {

    @GetMapping
    fun get(): Map<String, String> {
        val v = buildProperties.version
        logger.info("StatusResource v={}", v)
        return mapOf(
            Pair("version", v),
            Pair("clientId", contextStore.clientId)
        )
    }
}
