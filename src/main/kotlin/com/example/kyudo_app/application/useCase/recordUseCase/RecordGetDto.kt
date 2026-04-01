package com.example.kyudo_app.application.useCase.recordUseCase

import com.example.kyudo_app.domain.model.PracticeTypeConstants
import com.example.kyudo_app.domain.model.Record
import java.time.LocalDateTime

data class RecordGetDto(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val practiceTypeName: String? = null,
    val arrows: List<ArrowDto> = emptyList()
) {
    companion object {
        fun from(domain: Record): RecordGetDto {
            return RecordGetDto(
                recordId = domain.recordId,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                practiceDate = domain.practiceDate,
                practiceTypeId = domain.practiceTypeId,
                practiceTypeName = domain.practiceTypeId?.let { PracticeTypeConstants.PRACTICE_TYPE_MAP[it] },
                arrows = domain.arrows.map { ArrowDto.from(it) }
            )
        }
    }
}
