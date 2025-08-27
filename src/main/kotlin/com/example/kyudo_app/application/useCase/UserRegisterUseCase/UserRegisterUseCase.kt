package com.example.kyudo_app.application.useCase.UserRegisterUseCase

interface UserRegisterUseCase {
    fun register(request: UserRegisterParam): UserRegisterDto
}