package com.example.kyudo_app.domain.model

data class MonthlySummary(
    val month: String,
    val hitCount: Int,
    val totalShots: Int,
    val hitRate: Double
)
