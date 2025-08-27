package com.example.kyudo_app.application.useCase.GetUserByIdUseCase

interface UserGetByIdUseCase {
    fun getById(param: GetUserByIdParam): UserGetByIdDto?
}