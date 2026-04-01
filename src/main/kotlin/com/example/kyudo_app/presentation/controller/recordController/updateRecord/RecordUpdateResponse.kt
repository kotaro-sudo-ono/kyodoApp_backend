package com.example.kyudo_app.presentation.controller.recordController.updateRecord

import com.example.kyudo_app.application.useCase.recordUseCase.recordUpdate.RecordUpdateDto
import java.time.LocalDateTime

data class RecordUpdateResponse(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowUpdateResponseItem> = emptyList()
) {
    companion object {
        fun from(dto: RecordUpdateDto): RecordUpdateResponse {
            return RecordUpdateResponse(
                recordId = dto.recordId,
                hitCount = dto.hitCount,
                totalShots = dto.totalShots,
                practiceDate = dto.practiceDate,
                practiceTypeId = dto.practiceTypeId,
                arrows = dto.arrows.map { ArrowUpdateResponseItem(it.arrowId, it.arrowNumber, it.standNumber, it.positionX, it.positionY, it.isHit) }
            )
        }
    }
}

data class ArrowUpdateResponseItem(
    val arrowId: String?,
    val arrowNumber: Int,
    val standNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean
)
