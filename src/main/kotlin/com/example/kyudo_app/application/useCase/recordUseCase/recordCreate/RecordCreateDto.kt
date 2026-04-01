package com.example.kyudo_app.application.useCase.recordUseCase.recordCreate

import com.example.kyudo_app.domain.model.Record
import java.time.LocalDateTime

data class RecordCreateDto(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowCreateDto> = emptyList()
) {
    companion object {
        fun from(domain: Record): RecordCreateDto {
            return RecordCreateDto(
                recordId = domain.recordId,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                practiceDate = domain.practiceDate,
                practiceTypeId = domain.practiceTypeId,
                arrows = domain.arrows.map { ArrowCreateDto.from(it) }
            )
        }
    }
}

data class ArrowCreateDto(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(domain: com.example.kyudo_app.domain.model.ArrowRecord): ArrowCreateDto {
            return ArrowCreateDto(
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
