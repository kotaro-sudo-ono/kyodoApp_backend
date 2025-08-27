package com.example.kyudo_app.application.useCase.UserRegisterUseCase

data class UserRegisterParam(
    val name: String,
    val email: String,
    val rawPassword: String
)