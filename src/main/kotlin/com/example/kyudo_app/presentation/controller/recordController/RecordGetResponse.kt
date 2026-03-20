package com.example.kyudo_app.presentation.controller.recordController

import com.example.kyudo_app.application.useCase.recordUseCase.RecordGetDto
import java.time.LocalDateTime

data class RecordGetResponse(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowResponse> = emptyList()
) {
    companion object {
        fun from(dto: RecordGetDto): RecordGetResponse {
            return RecordGetResponse(
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
