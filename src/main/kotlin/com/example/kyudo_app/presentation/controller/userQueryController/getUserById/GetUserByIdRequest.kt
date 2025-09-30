package com.example.kyudo_app.presentation.controller.userQueryController.getUserById

import com.example.kyudo_app.application.useCase.getUserByIdUseCase.GetUserByIdParam

class GetUserByIdRequest (
    val userId: String?
) {
    fun toParam(): GetUserByIdParam = GetUserByIdParam(userId)
}
