package com.example.kyudo_app.application.useCase.getUserByIdUseCase

interface UserGetByIdUseCase {
    fun getById(param: GetUserByIdParam): UserGetByIdDto?
}