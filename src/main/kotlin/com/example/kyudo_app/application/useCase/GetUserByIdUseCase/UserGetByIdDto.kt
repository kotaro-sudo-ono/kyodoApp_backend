package com.example.kyudo_app.application.useCase.GetUserByIdUseCase

data class UserGetByIdDto(
    val userId: String?,
    val name: String,
    val email: String
)
