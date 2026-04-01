package com.example.kyudo_app.presentation.controller.recordController

import com.example.kyudo_app.application.useCase.recordUseCase.ArrowParam
import com.example.kyudo_app.application.useCase.recordUseCase.RecordSaveParam
import java.time.OffsetDateTime

data class RecordSaveRequest(
    val hitCount: Int,
    val totalShots: Int,
    val userId: String,
    val practiceDate: String? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowRequest> = emptyList()
) {
    fun toParam(): RecordSaveParam {
        return RecordSaveParam(
            this.hitCount,
            this.totalShots,
            this.userId,
            this.practiceDate?.let { OffsetDateTime.parse(it).toLocalDateTime() },
            this.practiceTypeId,
            this.arrows.map { arrow ->
                ArrowParam(
                    arrowNumber = arrow.arrowNumber,
                    positionX = arrow.positionX,
                    positionY = arrow.positionY,
                    isHit = arrow.isHit,
                    standNumber = arrow.standNumber
                )
            }
        )
    }
}

data class ArrowRequest(
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    init {
        require(standNumber >= 1) { "standNumber must be greater than or equal to 1" }
    }
}
