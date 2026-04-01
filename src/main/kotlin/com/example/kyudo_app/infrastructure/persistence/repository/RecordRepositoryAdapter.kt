package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.domain.model.Record
import com.example.kyudo_app.domain.repository.RecordRepositoryPort
import com.example.kyudo_app.infrastructure.persistence.mapper.ArrowRecordMapper
import com.example.kyudo_app.infrastructure.persistence.mapper.RecordMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalDateTime

@Repository
class RecordRepositoryAdapter(
    private val recordRepository: RecordRepository,
    private val userRepository: UserRepository
) : RecordRepositoryPort {

    override fun save(record: Record): Record {
        val entity = RecordMapper.toEntity(record)
        entity.user = record.user?.userId?.let { userRepository.findByIdOrNull(it) }
        record.arrows.forEach { arrow ->
            entity.arrows.add(ArrowRecordMapper.toEntity(arrow, entity))
        }
        return RecordMapper.toDomain(recordRepository.save(entity))
    }

    override fun update(record: Record): Record {
        val recordId = requireNotNull(record.recordId)
        val entity = recordRepository.findByIdOrNull(recordId)
            ?: throw NoSuchElementException("Record not found: $recordId")
        entity.hitCount = record.hitCount
        entity.totalShots = record.totalShots
        entity.practiceDate = record.practiceDate
        entity.practiceTypeId = record.practiceTypeId
        entity.arrows.clear()
        record.arrows.forEach { arrow ->
            entity.arrows.add(ArrowRecordMapper.toEntity(arrow, entity))
        }
        return RecordMapper.toDomain(recordRepository.save(entity))
    }

    override fun findById(recordId: String): Record? =
        recordRepository.findByIdOrNull(recordId)?.let { RecordMapper.toDomain(it) }

    override fun findByUserId(userId: String): List<Record> =
        recordRepository.findByUser_Id(userId).map { RecordMapper.toDomain(it) }

    override fun findByDate(date: LocalDate): List<Record> =
        recordRepository.findByPracticeDate(date).map { RecordMapper.toDomain(it) }

    override fun findByUserIdAndDateBetween(userId: String, start: LocalDateTime, end: LocalDateTime): List<Record> =
        recordRepository.findByUser_IdAndPracticeDateBetween(userId, start, end).map { RecordMapper.toDomain(it) }
}
