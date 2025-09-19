package com.example.kyudo_app.application.useCase.userGetAllUseCase

interface UserGetAllUseCase {
    fun getAllUsers(): List<UserGetAllDto>
}