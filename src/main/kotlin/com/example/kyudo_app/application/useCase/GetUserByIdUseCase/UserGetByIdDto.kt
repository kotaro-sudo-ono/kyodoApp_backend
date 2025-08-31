package com.example.kyudo_app.application.useCase.GetUserByIdUseCase

data class UserGetByIdDto(
    val userId: Int?,
    val name: String,
    val email: String
)
