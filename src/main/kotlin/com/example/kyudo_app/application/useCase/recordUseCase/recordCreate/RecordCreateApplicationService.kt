package com.example.kyudo_app.application.useCase.recordUseCase.recordCreate

import com.example.kyudo_app.domain.model.ArrowRecord
import com.example.kyudo_app.domain.model.Record
import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.domain.service.RecordDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecordCreateApplicationService(
    private val recordDomainService: RecordDomainService
) : RecordCreateUseCase {

    @Transactional
    override fun createRecord(command: RecordCreateCommand): RecordCreateDto {
        val domain = Record(
            recordId = null,
            hitCount = command.hitCount,
            totalShots = command.totalShots,
            user = User(
                userId = command.userId,
                name = "",
                email = "",
                userRole = 0,
                password = ""
            ),
            practiceDate = command.practiceDate,
            practiceTypeId = command.practiceTypeId,
            arrows = command.arrows.map { a ->
                ArrowRecord(
                    arrowId = null,
                    arrowNumber = a.arrowNumber,
                    positionX = a.positionX,
                    positionY = a.positionY,
                    isHit = a.isHit,
                    standNumber = a.standNumber
                )
            }
        )
        return RecordCreateDto.from(recordDomainService.saveRecord(domain))
    }
}
