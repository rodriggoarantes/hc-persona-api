package com.ras.persona.resource

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
    private val buildProperties : BuildProperties
) {

    @GetMapping
    fun get(): Map<String, String> {
        return mapOf(Pair("version", buildProperties.version))
    }
}
