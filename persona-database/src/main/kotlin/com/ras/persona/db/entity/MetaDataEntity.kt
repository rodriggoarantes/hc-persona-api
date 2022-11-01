package com.ras.persona.db.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime


class MetaDataEntity {
    @CreatedDate
    private val createdAt: LocalDateTime? = null

    @LastModifiedDate
    private val modifyAt: LocalDateTime? = null

    @CreatedBy
    private val createdByUser: String? = null

    @LastModifiedBy
    private val modifiedByUser: String? = null
}