package com.example.kyudo_app.presentation.controller.userRegisterController

import com.example.kyudo_app.application.useCase.UserRegisterUseCase.UserRegisterParam

data class UserRegisterRequest(
    val name: String,
    val email: String,
    val password: String
){
    fun toParam(): UserRegisterParam {
        return UserRegisterParam(
            name = this.name,
            email = this.email,
            rawPassword = this.password
        )
    }
}