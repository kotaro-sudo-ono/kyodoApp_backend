package com.example.kyudo_app.presentation.controller.recordController

import com.example.kyudo_app.application.useCase.recordUseCase.MonthlySummaryDto

data class MonthlySummaryResponse(
    val month: String,
    val hitCount: Int,
    val totalShots: Int,
    val hitRate: Double
) {
    companion object {
        fun from(dto: MonthlySummaryDto): MonthlySummaryResponse {
            return MonthlySummaryResponse(
                month = dto.month,
                hitCount = dto.hitCount,
                totalShots = dto.totalShots,
                hitRate = dto.hitRate
            )
        }
    }
}
