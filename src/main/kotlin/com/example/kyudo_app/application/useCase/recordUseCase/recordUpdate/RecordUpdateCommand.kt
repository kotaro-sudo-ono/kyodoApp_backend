package com.example.kyudo_app.application.useCase.recordUseCase.recordUpdate

import java.time.LocalDateTime

data class RecordUpdateCommand(
    val recordId: String,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowUpdateParam> = emptyList(),
)

data class ArrowUpdateParam(
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int
)
