package com.ras.persona.db.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.util.Optional


@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = ["com.ras.persona.db"])
class DbConfig {

    @Bean
    fun myAuditorProvider(auditionUserProvider: AuditionUserProvider): AuditorAware<String> {
        return AuditorAwareImpl(auditionUserProvider)
    }

}
