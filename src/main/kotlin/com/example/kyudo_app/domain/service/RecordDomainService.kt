package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.record
import com.example.kyudo_app.infrastructure.persistence.mapper.ArrowRecordMapper
import com.example.kyudo_app.infrastructure.persistence.mapper.RecordMapper
import com.example.kyudo_app.infrastructure.persistence.repository.RecordRepository
import com.example.kyudo_app.infrastructure.persistence.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecordDomainService(
    private val recordRepository: RecordRepository,
    private val userRepository: UserRepository
) {

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
    fun getRecordsByDate(date: java.time.LocalDate): List<record> {
        return recordRepository.findByPracticeDate(date).map { RecordMapper.toDomain(it) }
    }
}
