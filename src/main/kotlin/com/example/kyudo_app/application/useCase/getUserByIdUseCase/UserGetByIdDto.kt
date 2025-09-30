package com.example.kyudo_app.application.useCase.getUserByIdUseCase

data class UserGetByIdDto(
    val userId: String?,
    val name: String,
    val email: String
)
