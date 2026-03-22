package com.example.kyudo_app.domain.service

import com.example.kyudo_app.application.useCase.recordUseCase.MonthlySummaryDto
import com.example.kyudo_app.domain.model.record
import com.example.kyudo_app.infrastructure.persistence.mapper.ArrowRecordMapper
import com.example.kyudo_app.infrastructure.persistence.mapper.RecordMapper
import com.example.kyudo_app.infrastructure.persistence.repository.RecordRepository
import com.example.kyudo_app.infrastructure.persistence.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@Service
class RecordDomainService(
    private val recordRepository: RecordRepository,
    private val userRepository: UserRepository
) {

    companion object {
        val PRACTICE_TYPE_MAP = mapOf(1 to "練習", 2 to "個人戦", 3 to "チーム戦")
    }

    @Transactional
    fun saveRecord(domain: record): record {
        val entity = RecordMapper.toEntity(domain)
        entity.user = domain.user?.userId?.let { userRepository.findByIdOrNull(it) }
        domain.arrows.forEach { arrow ->
            val arrowEntity = ArrowRecordMapper.toEntity(arrow, entity)
            entity.arrows.add(arrowEntity)
        }
        val saved = recordRepository.save(entity)
        return RecordMapper.toDomain(saved)
    }

    @Transactional(readOnly = true)
    fun getRecordsByUserId(userId: String): List<record> {
        return recordRepository.findByUser_Id(userId).map { RecordMapper.toDomain(it) }
    }

    @Transactional(readOnly = true)
    fun getRecordsByDate(date: LocalDate): List<record> {
        return recordRepository.findByPracticeDate(date).map { RecordMapper.toDomain(it) }
    }

    @Transactional(readOnly = true)
    fun getMonthlySummary(userId: String, months: List<String>): List<MonthlySummaryDto> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM")
        val yearMonths = months.map { YearMonth.parse(it) }
        val start = yearMonths.minOf { it.atDay(1) }.atStartOfDay()
        val end = yearMonths.maxOf { it.atEndOfMonth() }.plusDays(1).atStartOfDay()

        val records = recordRepository
            .findByUser_IdAndPracticeDateBetween(userId, start, end)
            .map { RecordMapper.toDomain(it) }

        val grouped = records.groupBy { record ->
            record.practiceDate?.toLocalDate()?.format(formatter) ?: ""
        }

        return months.map { month ->
            val monthRecords = grouped[month] ?: emptyList()
            val totalHit = monthRecords.sumOf { it.hitCount }
            val totalShots = monthRecords.sumOf { it.totalShots }
            val hitRate = if (totalShots > 0) {
                totalHit.toDouble() / totalShots
            } else {
                0.0
            }
            MonthlySummaryDto(
                month = month,
                hitCount = totalHit,
                totalShots = totalShots,
                hitRate = hitRate
            )
        }
    }
}
