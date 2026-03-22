package com.example.kyudo_app.application.useCase.recordUseCase

data class MonthlySummaryDto(
    val month: String,
    val hitCount: Int,
    val totalShots: Int,
    val hitRate: Double
)
