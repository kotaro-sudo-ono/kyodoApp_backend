package com.example.kyudo_app.application.useCase.recordUseCase.recordUpdate

import com.example.kyudo_app.domain.model.record
import java.time.LocalDateTime

data class RecordUpdateDto(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowUpdateDto> = emptyList()
) {
    companion object {
        fun from(domain: record): RecordUpdateDto {
            return RecordUpdateDto(
                recordId = domain.recordId,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                practiceDate = domain.practiceDate,
                practiceTypeId = domain.practiceTypeId,
                arrows = domain.arrows.map { ArrowUpdateDto.from(it) }
            )
        }
    }
}

data class ArrowUpdateDto(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean
) {
    companion object {
        fun from(domain: com.example.kyudo_app.domain.model.ArrowRecord): ArrowUpdateDto {
            return ArrowUpdateDto(
                arrowId = domain.arrowId,
                arrowNumber = domain.arrowNumber,
                positionX = domain.positionX,
                positionY = domain.positionY,
                isHit = domain.isHit
            )
        }
    }
}
