package com.ras.persona.db.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("persona")
data class PersonaEntity (
    @Id
    val id: String,

    @Indexed(unique = true)
    val name: String,

    @Field(name="email")
    @Indexed(unique = true)
    val email: String,

    val data: Map<String, Any>
) {
    private var meta: MetaDataEntity? = null
}