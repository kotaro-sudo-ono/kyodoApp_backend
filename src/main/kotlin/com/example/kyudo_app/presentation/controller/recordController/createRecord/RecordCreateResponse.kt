package com.example.kyudo_app.presentation.controller.recordController.createRecord

import com.example.kyudo_app.application.useCase.recordUseCase.recordCreate.RecordCreateDto
import java.time.LocalDateTime

data class RecordCreateResponse(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowCreateResponseItem> = emptyList()
) {
    companion object {
        fun from(dto: RecordCreateDto): RecordCreateResponse {
            return RecordCreateResponse(
                recordId = dto.recordId,
                hitCount = dto.hitCount,
                totalShots = dto.totalShots,
                practiceDate = dto.practiceDate,
                practiceTypeId = dto.practiceTypeId,
                arrows = dto.arrows.map { ArrowCreateResponseItem.from(it) }
            )
        }
    }
}

data class ArrowCreateResponseItem(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(dto: com.example.kyudo_app.application.useCase.recordUseCase.recordCreate.ArrowCreateDto): ArrowCreateResponseItem {
            return ArrowCreateResponseItem(
                arrowId = dto.arrowId,
                arrowNumber = dto.arrowNumber,
                positionX = dto.positionX,
                positionY = dto.positionY,
                isHit = dto.isHit,
                standNumber = dto.standNumber
            )
        }
    }
}
