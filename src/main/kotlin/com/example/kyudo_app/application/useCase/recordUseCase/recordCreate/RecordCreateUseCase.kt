package com.example.kyudo_app.application.useCase.recordUseCase.recordCreate

interface RecordCreateUseCase {
    fun createRecord(command: RecordCreateCommand): RecordCreateDto
}
