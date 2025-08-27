package com.example.kyudo_app.application.useCase.UserRegisterUseCase

import com.example.kyudo_app.domain.model.User

data class UserRegisterDto(
    val id: Long,
    val name: String,
    val email: String
){
    companion object{
        fun from(user: User): UserRegisterDto {
            return UserRegisterDto(
                id = user.userId,
                name = user.name,
                email = user.email
            )
        }
    }
}