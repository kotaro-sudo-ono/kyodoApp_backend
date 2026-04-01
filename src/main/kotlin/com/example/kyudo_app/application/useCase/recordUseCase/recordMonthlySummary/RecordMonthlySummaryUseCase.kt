package com.example.kyudo_app.application.useCase.recordUseCase.recordMonthlySummary

interface RecordMonthlySummaryUseCase {
    fun getMonthlySummary(userId: String, months: List<String>): List<RecordMonthlySummaryDto>
}
