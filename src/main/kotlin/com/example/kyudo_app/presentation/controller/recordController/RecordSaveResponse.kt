package com.example.kyudo_app.presentation.controller.recordController

import com.example.kyudo_app.application.useCase.recordUseCase.ArrowDto
import com.example.kyudo_app.application.useCase.recordUseCase.RecordSaveDto
import java.time.LocalDateTime

data class RecordSaveResponse(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowResponse> = emptyList()
) {
    companion object {
        fun from(dto: RecordSaveDto): RecordSaveResponse {
            return RecordSaveResponse(
                recordId = dto.recordId,
                hitCount = dto.hitCount,
                totalShots = dto.totalShots,
                practiceDate = dto.practiceDate,
                practiceTypeId = dto.practiceTypeId,
                arrows = dto.arrows.map { ArrowResponse.from(it) }
            )
        }
    }
}

data class ArrowResponse(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(dto: ArrowDto): ArrowResponse {
            return ArrowResponse(
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
