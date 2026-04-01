package com.example.kyudo_app.application.useCase.recordUseCase.recordGetByDate

import com.example.kyudo_app.domain.model.PracticeTypeConstants
import com.example.kyudo_app.domain.model.Record
import java.time.LocalDateTime

data class RecordGetByDateDto(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val practiceTypeName: String? = null,
    val arrows: List<ArrowGetByDateDto> = emptyList()
) {
    companion object {
        fun from(domain: Record): RecordGetByDateDto {
            return RecordGetByDateDto(
                recordId = domain.recordId,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                practiceDate = domain.practiceDate,
                practiceTypeId = domain.practiceTypeId,
                practiceTypeName = domain.practiceTypeId?.let { PracticeTypeConstants.PRACTICE_TYPE_MAP[it] },
                arrows = domain.arrows.map { ArrowGetByDateDto.from(it) }
            )
        }
    }
}

data class ArrowGetByDateDto(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(domain: com.example.kyudo_app.domain.model.ArrowRecord): ArrowGetByDateDto {
            return ArrowGetByDateDto(
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
