package com.example.kyudo_app.application.useCase.recordUseCase.recordGetByDate

import java.time.LocalDate

interface RecordGetByDateUseCase {
    fun getRecordsByDate(date: LocalDate): List<RecordGetByDateDto>
}
