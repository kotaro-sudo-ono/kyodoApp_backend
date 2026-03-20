package com.example.kyudo_app.application.useCase.recordUseCase

import com.example.kyudo_app.domain.model.record
import java.time.LocalDateTime

data class RecordGetDto(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowDto> = emptyList()
) {
    companion object {
        fun from(domain: record): RecordGetDto {
            return RecordGetDto(
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
