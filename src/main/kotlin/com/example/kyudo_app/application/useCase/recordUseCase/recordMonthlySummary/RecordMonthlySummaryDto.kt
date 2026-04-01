package com.example.kyudo_app.application.useCase.recordUseCase.recordMonthlySummary

import com.example.kyudo_app.domain.model.MonthlySummary

data class RecordMonthlySummaryDto(
    val month: String,
    val hitCount: Int,
    val totalShots: Int,
    val hitRate: Double
) {
    companion object {
        fun from(domain: MonthlySummary): RecordMonthlySummaryDto {
            return RecordMonthlySummaryDto(
                month = domain.month,
                hitCount = domain.hitCount,
                totalShots = domain.totalShots,
                hitRate = domain.hitRate
            )
        }
    }
}
