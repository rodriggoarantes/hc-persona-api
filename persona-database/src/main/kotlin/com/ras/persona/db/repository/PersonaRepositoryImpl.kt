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
        val entity = persona.toEntity()

        repository.findById(entity.id).let {
            it.ifPresent { db ->
                entity.version = db.version
                entity.createdAt = db.createdAt
                entity.modifyAt = db.modifyAt
                entity.createdByUser = db.createdByUser
                entity.modifiedByUser = db.modifiedByUser
            }
        }

        repository.save(entity)
    }

    override fun isExistingEmail(email: String): Boolean {
        return repository.findOneByEmail(email).isPresent
    }

}