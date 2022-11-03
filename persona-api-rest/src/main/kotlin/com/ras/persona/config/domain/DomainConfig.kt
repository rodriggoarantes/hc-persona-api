package com.ras.persona.config.domain

import com.ras.persona.usecase.CreatePersonaUseCase
import com.ras.persona.usecase.CreatePersonaUseCaseImpl
import com.ras.persona.usecase.PersonaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainConfig {

    @Bean("createPersonaUseCase")
    fun createPersonaUseCase(personaRepository: PersonaRepository): CreatePersonaUseCase {
        return CreatePersonaUseCaseImpl(personaRepository)
    }
}