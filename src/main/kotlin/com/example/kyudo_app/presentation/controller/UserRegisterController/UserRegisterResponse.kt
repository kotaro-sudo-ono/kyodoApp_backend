package com.example.kyudo_app.presentation.controller.UserRegisterController

import com.example.kyudo_app.application.useCase.UserRegisterUseCase.UserRegisterDto

data class UserRegisterResponse(
    val id: Long,
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