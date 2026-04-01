package com.example.kyudo_app.application.useCase.userLoginUseCase

interface TokenGeneratorPort {
    fun generateToken(email: String, userId: String): String
}
