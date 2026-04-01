package com.example.kyudo_app.presentation.controller.recordController.getRecordByUser

import com.example.kyudo_app.application.useCase.recordUseCase.recordGetByUser.RecordGetByUserDto
import java.time.LocalDateTime

data class RecordGetByUserResponse(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val practiceType: String? = null,
    val arrows: List<ArrowGetByUserResponseItem> = emptyList()
) {
    companion object {
        fun from(dto: RecordGetByUserDto): RecordGetByUserResponse {
            return RecordGetByUserResponse(
                recordId = dto.recordId,
                hitCount = dto.hitCount,
                totalShots = dto.totalShots,
                practiceDate = dto.practiceDate,
                practiceTypeId = dto.practiceTypeId,
                practiceType = dto.practiceTypeName,
                arrows = dto.arrows.map { ArrowGetByUserResponseItem.from(it) }
            )
        }
    }
}

data class ArrowGetByUserResponseItem(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(dto: com.example.kyudo_app.application.useCase.recordUseCase.recordGetByUser.ArrowGetByUserDto): ArrowGetByUserResponseItem {
            return ArrowGetByUserResponseItem(
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
