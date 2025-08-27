package com.example.kyudo_app.application.useCase.UserLoginUseCase


interface UserLoginUseCase {
    fun login(param: UserLoginParam): UserLoginDto
}
