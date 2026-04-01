package com.example.kyudo_app.application.useCase.recordUseCase.recordMonthlySummary

import com.example.kyudo_app.domain.service.RecordDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecordMonthlySummaryApplicationService(
    private val recordDomainService: RecordDomainService
) : RecordMonthlySummaryUseCase {

    @Transactional(readOnly = true)
    override fun getMonthlySummary(userId: String, months: List<String>): List<RecordMonthlySummaryDto> =
        recordDomainService.getMonthlySummary(userId, months).map { RecordMonthlySummaryDto.from(it) }
}
