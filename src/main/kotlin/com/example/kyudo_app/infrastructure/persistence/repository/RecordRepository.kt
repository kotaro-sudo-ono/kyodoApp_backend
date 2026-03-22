package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.infrastructure.persistence.entity.RecordEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.time.LocalDateTime

interface RecordRepository : JpaRepository<RecordEntity, String> {
    fun findByUser_Id(userId: String): List<RecordEntity>

    @Query("SELECT r FROM RecordEntity r WHERE DATE(r.practiceDate) = :date")
    fun findByPracticeDate(@Param("date") date: LocalDate): List<RecordEntity>

    fun findByUser_IdAndPracticeDateBetween(
        userId: String,
        start: LocalDateTime,
        end: LocalDateTime
    ): List<RecordEntity>
}
