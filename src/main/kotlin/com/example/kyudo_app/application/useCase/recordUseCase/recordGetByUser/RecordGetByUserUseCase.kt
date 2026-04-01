package com.example.kyudo_app.application.useCase.recordUseCase.recordGetByUser

interface RecordGetByUserUseCase {
    fun getRecordsByUserId(userId: String): List<RecordGetByUserDto>
}
