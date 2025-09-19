package com.example.kyudo_app.presentation.controller.userQueryController.getAllUsers

import com.example.kyudo_app.application.useCase.userGetAllUseCase.UserGetAllDto

data class UserGetAllResponse(
    val id: String?,
    val name: String,
    val email: String
) {
    companion object {
        fun from(dto: UserGetAllDto): UserGetAllResponse {
            return UserGetAllResponse(
                id = dto.id,
                name = dto.name,
                email = dto.email
            )
        }
    }
}
