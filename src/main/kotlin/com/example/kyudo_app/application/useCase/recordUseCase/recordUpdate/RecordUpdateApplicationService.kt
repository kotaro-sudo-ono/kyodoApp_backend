package com.example.kyudo_app.application.useCase.recordUseCase.recordUpdate

import com.example.kyudo_app.domain.model.ArrowRecord
import com.example.kyudo_app.domain.model.record
import com.example.kyudo_app.domain.service.RecordDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecordUpdateApplicationService(
    private val recordDomainService: RecordDomainService
) : RecordUpdateUseCase {

    @Transactional
    override fun updateRecord(command: RecordUpdateCommand): RecordUpdateDto {
        val domain = record(
            recordId = command.recordId,
            hitCount = command.hitCount,
            totalShots = command.totalShots,
            practiceDate = command.practiceDate,
            practiceTypeId = command.practiceTypeId,
            arrows = command.arrows.map { a ->
                ArrowRecord(
                    arrowId = null,
                    arrowNumber = a.arrowNumber,
                    positionX = a.positionX,
                    positionY = a.positionY,
                    isHit = a.isHit
                )
            }
        )
        val updated = recordDomainService.updateRecord(domain)
        return RecordUpdateDto.from(updated)
    }
}
