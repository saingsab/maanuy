package com.ig.maanuy.model

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

@MappedSuperclass
open class BaseEntity {
    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null

    @Column(name = "created_by", updatable = false)
    var createdBy: String? = null

    @Column(name = "updated_by")
    var updatedBy: String? = null

    @PrePersist
    protected fun onCreate() {
        createdAt = LocalDateTime.now()
        updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}