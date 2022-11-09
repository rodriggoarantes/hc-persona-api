package com.ras.persona.db.config

import org.springframework.data.domain.AuditorAware
import java.util.*

class AuditorAwareImpl(private val auditionUserProvider: AuditionUserProvider) : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.ofNullable(auditionUserProvider.userId())
    }
}