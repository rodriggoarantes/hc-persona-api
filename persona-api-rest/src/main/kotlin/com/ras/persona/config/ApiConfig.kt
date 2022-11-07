package com.ras.persona.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class ApiConfig {

    @Bean
    fun testObjectMapper(builder: Jackson2ObjectMapperBuilder): ObjectMapper {
         return builder.build()
    }
}