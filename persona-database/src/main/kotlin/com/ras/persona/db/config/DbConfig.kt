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
    fun myAuditorProvider(): AuditorAware<String> {
        return AuditorAwareImpl()
    }

}

class AuditorAwareImpl : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        // TODO implementar auditoria por ThreadLocal
        return Optional.ofNullable("ADMIN")
    }
}