package com.example.kyudo_app.presentation.controller.recordController.monthlySummary

import com.example.kyudo_app.application.useCase.recordUseCase.recordMonthlySummary.RecordMonthlySummaryDto

data class RecordMonthlySummaryResponse(
    val month: String,
    val hitCount: Int,
    val totalShots: Int,
    val hitRate: Double
) {
    companion object {
        fun from(dto: RecordMonthlySummaryDto): RecordMonthlySummaryResponse {
            return RecordMonthlySummaryResponse(
                month = dto.month,
                hitCount = dto.hitCount,
                totalShots = dto.totalShots,
                hitRate = dto.hitRate
            )
        }
    }
}
