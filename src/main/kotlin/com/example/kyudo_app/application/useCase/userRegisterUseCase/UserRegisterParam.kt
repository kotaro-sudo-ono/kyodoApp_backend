package com.example.kyudo_app.application.useCase.userRegisterUseCase

data class UserRegisterParam(
    val name: String,
    val email: String,
    val rawPassword: String
)