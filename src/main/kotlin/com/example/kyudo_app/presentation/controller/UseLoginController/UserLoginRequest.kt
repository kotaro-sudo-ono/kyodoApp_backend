package com.example.kyudo_app.presentation.controller.UseLoginController

import com.example.kyudo_app.application.useCase.UserLoginUseCase.UserLoginParam

data class UserLoginRequest(
    val email: String,
    val password: String
) {
    fun toParam(): UserLoginParam = UserLoginParam(email, password)
}