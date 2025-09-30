package com.example.kyudo_app.presentation.controller.userRegisterController

import com.example.kyudo_app.application.useCase.UserRegisterUseCase.UserRegisterDto

data class UserRegisterResponse(
    val id: String?,
    val name: String,
    val email: String
){
    companion object {
        fun from(dto: UserRegisterDto): UserRegisterResponse {
            return UserRegisterResponse(
                id = dto.id,
                name = dto.name,
                email = dto.email
            )
        }
    }
}
