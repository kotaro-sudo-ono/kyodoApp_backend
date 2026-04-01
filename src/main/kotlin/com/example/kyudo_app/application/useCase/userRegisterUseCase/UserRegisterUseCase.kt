package com.example.kyudo_app.application.useCase.userRegisterUseCase

interface UserRegisterUseCase {
    fun register(request: UserRegisterParam): UserRegisterDto
}