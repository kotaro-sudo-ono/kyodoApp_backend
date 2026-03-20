package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.infrastructure.persistence.entity.ArrowRecordEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ArrowRecordRepository : JpaRepository<ArrowRecordEntity, String> {
    fun findByRecord_Id(recordId: String): List<ArrowRecordEntity>
}
