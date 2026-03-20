package com.example.kyudo_app.application.useCase.recordUseCase

interface RecordUseCase {
    fun saveRecord(param: RecordSaveParam): RecordSaveDto
    fun getRecordsByUserId(userId: String): List<RecordGetDto>
    fun getRecordsByDate(date: java.time.LocalDate): List<RecordGetDto>
}
