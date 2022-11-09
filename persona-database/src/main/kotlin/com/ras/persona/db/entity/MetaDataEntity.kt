package com.ras.persona.db.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.time.LocalDateTime


abstract class MetaDataEntity(
    @Version
    var version: Long? = null,

    @CreatedDate
    var createdAt: LocalDateTime? = null,

    @LastModifiedDate
    var modifyAt: LocalDateTime? = null,

    @CreatedBy
    var createdByUser: String? = null,

    @LastModifiedBy
    var modifiedByUser: String? = null
)