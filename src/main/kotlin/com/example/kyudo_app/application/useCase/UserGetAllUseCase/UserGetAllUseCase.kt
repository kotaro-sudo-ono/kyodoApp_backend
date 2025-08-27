package com.example.kyudo_app.application.useCase.UserGetAllUseCase

interface UserGetAllUseCase {
    fun getAllUsers(): List<UserGetAllDto>
}