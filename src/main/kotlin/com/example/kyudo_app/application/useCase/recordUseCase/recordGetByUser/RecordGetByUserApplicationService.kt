package com.example.kyudo_app.application.useCase.recordUseCase.recordGetByUser

import com.example.kyudo_app.domain.service.RecordDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecordGetByUserApplicationService(
    private val recordDomainService: RecordDomainService
) : RecordGetByUserUseCase {

    @Transactional(readOnly = true)
    override fun getRecordsByUserId(userId: String): List<RecordGetByUserDto> =
        recordDomainService.getRecordsByUserId(userId).map { RecordGetByUserDto.from(it) }
}
