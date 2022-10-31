package com.ras.persona.db.repository

import com.ras.persona.db.entity.PersonaEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface PersonaMongoRepository: MongoRepository<PersonaEntity, String> {

    fun findOneByEmail(email:String): Optional<PersonaEntity>

}