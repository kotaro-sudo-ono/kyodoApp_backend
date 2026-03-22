package com.example.kyudo_app.application.useCase.recordUseCase

import com.example.kyudo_app.domain.model.ArrowRecord
import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.domain.model.record
import com.example.kyudo_app.domain.service.RecordDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecordApplicationService(
    private val recordDomainService: RecordDomainService
) : RecordUseCase {

    @Transactional
    override fun saveRecord(param: RecordSaveParam): RecordSaveDto {
        val domain = record(
            recordId = null,
            hitCount = param.hitCount,
            totalShots = param.totalShots,
            user = User(
                userId = param.userId,
                name = "",
                email = "",
                userRole = 0,
                password = ""
            ),
            practiceDate = param.practiceDate,
            practiceTypeId = param.practiceTypeId,
            arrows = param.arrows.map { a ->
                ArrowRecord(
                    arrowId = null,
                    arrowNumber = a.arrowNumber,
                    positionX = a.positionX,
                    positionY = a.positionY,
                    isHit = a.isHit
                )
            }
        )
        val saved = recordDomainService.saveRecord(domain)
        val hoge = RecordSaveDto.from(saved)
        return hoge;
    }

    @Transactional(readOnly = true)
    override fun getRecordsByUserId(userId: String): List<RecordGetDto> {
        return recordDomainService.getRecordsByUserId(userId).map { RecordGetDto.from(it) }
    }

    @Transactional(readOnly = true)
    override fun getRecordsByDate(date: java.time.LocalDate): List<RecordGetDto> {
        return recordDomainService.getRecordsByDate(date).map { RecordGetDto.from(it) }
    }

    @Transactional(readOnly = true)
    override fun getMonthlySummary(userId: String, months: List<String>): List<MonthlySummaryDto> {
        return recordDomainService.getMonthlySummary(
            userId,
            months
        )
    }
}
