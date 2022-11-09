package com.ras.persona.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.ras.persona.config.context.ContextStore
import com.ras.persona.db.config.AuditionUserProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class Config {

    @Bean
    fun testObjectMapper(builder: Jackson2ObjectMapperBuilder): ObjectMapper = builder.build()

    @Bean("auditionUserProvider")
    fun dbAuditionUserProvider(contextStore: ContextStore): AuditionUserProvider = object: AuditionUserProvider {
        override fun userId(): String = contextStore.userId
    }

}