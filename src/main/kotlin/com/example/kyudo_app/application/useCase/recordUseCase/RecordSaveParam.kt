package com.example.kyudo_app.application.useCase.recordUseCase

import java.time.LocalDateTime

data class RecordSaveParam(
    val hitCount: Int,
    val totalShots: Int,
    val userId: String,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowParam> = emptyList()
)

data class ArrowParam(
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
)
