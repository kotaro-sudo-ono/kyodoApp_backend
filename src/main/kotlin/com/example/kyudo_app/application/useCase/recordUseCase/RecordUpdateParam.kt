package com.example.kyudo_app.application.useCase.recordUseCase

import java.time.LocalDateTime

data class RecordUpdateParam(
    val recordId: String,
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowParam> = emptyList()
)
