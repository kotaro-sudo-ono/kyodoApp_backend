package com.example.kyudo_app.presentation.controller.recordController.getRecordByDate

import com.example.kyudo_app.application.useCase.recordUseCase.recordGetByDate.RecordGetByDateDto
import java.time.LocalDateTime

data class RecordGetByDateResponse(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val practiceType: String? = null,
    val arrows: List<ArrowGetByDateResponseItem> = emptyList()
) {
    companion object {
        fun from(dto: RecordGetByDateDto): RecordGetByDateResponse {
            return RecordGetByDateResponse(
                recordId = dto.recordId,
                hitCount = dto.hitCount,
                totalShots = dto.totalShots,
                practiceDate = dto.practiceDate,
                practiceTypeId = dto.practiceTypeId,
                practiceType = dto.practiceTypeName,
                arrows = dto.arrows.map { ArrowGetByDateResponseItem.from(it) }
            )
        }
    }
}

data class ArrowGetByDateResponseItem(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(dto: com.example.kyudo_app.application.useCase.recordUseCase.recordGetByDate.ArrowGetByDateDto): ArrowGetByDateResponseItem {
            return ArrowGetByDateResponseItem(
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
