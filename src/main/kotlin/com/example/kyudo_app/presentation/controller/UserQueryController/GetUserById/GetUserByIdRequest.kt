package com.example.kyudo_app.presentation.controller.UserQueryController.GetUserById

import com.example.kyudo_app.application.useCase.GetUserByIdUseCase.GetUserByIdParam

class GetUserByIdRequest (
    val userId: String?
) {
    fun toParam(): GetUserByIdParam = GetUserByIdParam(userId)
}
