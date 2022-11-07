package com.ras.persona.config.domain

import com.ras.persona.usecase.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainConfig {

    @Bean("createPersonaUseCase")
    fun createPersonaUseCase(personaRepository: PersonaRepository): CreatePersonaUseCase {
        return CreatePersonaUseCaseImpl(personaRepository)
    }

    @Bean("createDataOfPersonaUseCase")
    fun createDataOfPersonaUseCase(personaRepository: PersonaRepository): CreateDataOfPersonaUseCase {
        return CreateDataOfPersonaUseCaseImpl(personaRepository)
    }
}