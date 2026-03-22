package com.example.kyudo_app.application.useCase.recordUseCase

import com.example.kyudo_app.domain.model.record
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
        private val PRACTICE_TYPE_MAP = mapOf(1 to "練習", 2 to "個人戦", 3 to "チーム戦")

        fun from(domain: record): RecordGetDto {
            return RecordGetDto(
                recordId = domain.recordId,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                practiceDate = domain.practiceDate,
                practiceTypeId = domain.practiceTypeId,
                practiceTypeName = domain.practiceTypeId?.let { PRACTICE_TYPE_MAP[it] },
                arrows = domain.arrows.map { ArrowDto.from(it) }
            )
        }
    }
}
