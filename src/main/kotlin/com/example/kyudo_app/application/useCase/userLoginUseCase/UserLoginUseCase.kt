package com.example.kyudo_app.application.useCase.userLoginUseCase


interface UserLoginUseCase {
    fun login(param: UserLoginParam): UserLoginDto
}
