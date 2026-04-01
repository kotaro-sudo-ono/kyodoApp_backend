package com.example.kyudo_app.domain.repository

import com.example.kyudo_app.domain.model.Record
import java.time.LocalDate
import java.time.LocalDateTime

interface RecordRepositoryPort {
    fun save(record: Record): Record
    fun update(record: Record): Record
    fun findById(recordId: String): Record?
    fun findByUserId(userId: String): List<Record>
    fun findByDate(date: LocalDate): List<Record>
    fun findByUserIdAndDateBetween(userId: String, start: LocalDateTime, end: LocalDateTime): List<Record>
}
