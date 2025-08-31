package com.example.kyudo_app.presentation.controller.UserQueryController.GetUserById

import com.example.kyudo_app.application.useCase.GetUserByIdUseCase.UserGetByIdDto

class GetUserByIdResponse(
    val userId: String?,
    val name: String,
    val email: String
){
    companion object {
        fun from(dto: UserGetByIdDto): GetUserByIdResponse {
            return GetUserByIdResponse(
                userId = dto.userId,
                name = dto.name,
                email = dto.email
            )
        }
    }
}
