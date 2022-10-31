package com.ras.persona.db.repository

import com.ras.persona.db.converter.toDataOut
import com.ras.persona.db.converter.toEntity
import com.ras.persona.domain.exception.ResourceNotFoundException
import com.ras.persona.usecase.PersonaRepository
import com.ras.persona.usecase.boundary.data.output.PersonaDataOut
import org.springframework.stereotype.Repository

@Repository
class PersonaRepositoryImpl(private val repository: PersonaMongoRepository): PersonaRepository {

    override fun findById(id: String): PersonaDataOut {
        val entity = repository.findById(id).orElseThrow { ResourceNotFoundException(id) }
        return entity.toDataOut()
    }

    override fun save(persona: PersonaDataOut) {
        repository.save(persona.toEntity())
    }

    override fun isExistingEmail(email: String): Boolean {
        return repository.findOneByEmail(email).isPresent
    }

}