package com.example.kyudo_app.application.useCase.recordUseCase

import com.example.kyudo_app.domain.model.record
import java.time.LocalDateTime

data class RecordSaveDto(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowDto> = emptyList()
) {
    companion object {
        fun from(domain: record): RecordSaveDto {
            return RecordSaveDto(
                recordId = domain.recordId,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                practiceDate = domain.practiceDate,
                practiceTypeId = domain.practiceTypeId,
                arrows = domain.arrows.map { ArrowDto.from(it) }
            )
        }
    }
}

data class ArrowDto(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(domain: com.example.kyudo_app.domain.model.ArrowRecord): ArrowDto {
            return ArrowDto(
                arrowId = domain.arrowId,
                arrowNumber = domain.arrowNumber,
                positionX = domain.positionX,
                positionY = domain.positionY,
                isHit = domain.isHit,
                standNumber = domain.standNumber
            )
        }
    }
}
