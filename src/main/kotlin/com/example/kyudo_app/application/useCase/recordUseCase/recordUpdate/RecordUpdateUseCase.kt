package com.example.kyudo_app.application.useCase.recordUseCase.recordUpdate

interface RecordUpdateUseCase {
    fun updateRecord(command: RecordUpdateCommand): RecordUpdateDto
}
