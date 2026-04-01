package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.MonthlySummary
import com.example.kyudo_app.domain.model.Record
import com.example.kyudo_app.domain.repository.RecordRepositoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@Service
class RecordDomainService(
    private val recordRepository: RecordRepositoryPort
) {

    @Transactional
    fun saveRecord(domain: Record): Record = recordRepository.save(domain)

    @Transactional
    fun updateRecord(domain: Record): Record {
        val recordId = requireNotNull(domain.recordId) { "recordId is required for update" }
        recordRepository.findById(recordId)
            ?: throw NoSuchElementException("Record not found: $recordId")
        return recordRepository.update(domain)
    }

    @Transactional(readOnly = true)
    fun getRecordsByUserId(userId: String): List<Record> = recordRepository.findByUserId(userId)

    @Transactional(readOnly = true)
    fun getRecordsByDate(date: LocalDate): List<Record> = recordRepository.findByDate(date)

    @Transactional(readOnly = true)
    fun getMonthlySummary(userId: String, months: List<String>): List<MonthlySummary> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM")
        val yearMonths = months.map { YearMonth.parse(it) }
        val start = yearMonths.minOf { it.atDay(1) }.atStartOfDay()
        val end = yearMonths.maxOf { it.atEndOfMonth() }.plusDays(1).atStartOfDay()

        val records = recordRepository.findByUserIdAndDateBetween(userId, start, end)

        val grouped = records.groupBy { record ->
            record.practiceDate?.toLocalDate()?.format(formatter) ?: ""
        }

        return months.map { month ->
            val monthRecords = grouped[month] ?: emptyList()
            val totalHit = monthRecords.sumOf { it.hitCount }
            val totalShots = monthRecords.sumOf { it.totalShots }
            val hitRate = if (totalShots > 0) totalHit.toDouble() / totalShots else 0.0
            MonthlySummary(
                month = month,
                hitCount = totalHit,
                totalShots = totalShots,
                hitRate = hitRate
            )
        }
    }
}
