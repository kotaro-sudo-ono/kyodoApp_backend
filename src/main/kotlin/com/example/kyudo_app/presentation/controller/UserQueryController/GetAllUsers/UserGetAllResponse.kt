package com.example.kyudo_app.presentation.controller.UserQueryController.GetAllUsers

import com.example.kyudo_app.application.useCase.UserGetAllUseCase.UserGetAllDto

data class UserGetAllResponse(
    val id: Int?,
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
