package com.example.kyudo_app.application.useCase.recordUseCase.recordGetByUser

import com.example.kyudo_app.domain.model.PracticeTypeConstants
import com.example.kyudo_app.domain.model.Record
import java.time.LocalDateTime

data class RecordGetByUserDto(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val practiceTypeName: String? = null,
    val arrows: List<ArrowGetByUserDto> = emptyList()
) {
    companion object {
        fun from(domain: Record): RecordGetByUserDto {
            return RecordGetByUserDto(
                recordId = domain.recordId,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                practiceDate = domain.practiceDate,
                practiceTypeId = domain.practiceTypeId,
                practiceTypeName = domain.practiceTypeId?.let { PracticeTypeConstants.PRACTICE_TYPE_MAP[it] },
                arrows = domain.arrows.map { ArrowGetByUserDto.from(it) }
            )
        }
    }
}

data class ArrowGetByUserDto(
    val arrowId: String?,
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    companion object {
        fun from(domain: com.example.kyudo_app.domain.model.ArrowRecord): ArrowGetByUserDto {
            return ArrowGetByUserDto(
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
