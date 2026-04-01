package com.example.kyudo_app.application.useCase.recordUseCase.recordGetByDate

import com.example.kyudo_app.domain.service.RecordDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class RecordGetByDateApplicationService(
    private val recordDomainService: RecordDomainService
) : RecordGetByDateUseCase {

    @Transactional(readOnly = true)
    override fun getRecordsByDate(date: LocalDate): List<RecordGetByDateDto> =
        recordDomainService.getRecordsByDate(date).map { RecordGetByDateDto.from(it) }
}
