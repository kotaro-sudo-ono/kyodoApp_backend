package com.example.kyudo_app.application.useCase.recordUseCase.recordCreate

import java.time.LocalDateTime

data class RecordCreateCommand(
    val hitCount: Int,
    val totalShots: Int,
    val userId: String,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowCreateParam> = emptyList()
)

data class ArrowCreateParam(
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
)
