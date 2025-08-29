package com.example.kyudo_app.application.useCase.UserGetAllUseCase

import org.springframework.stereotype.Service

@Service
class UserGetAllApplicationService : UserGetAllUseCase {

    override fun getAllUsers(): List<UserGetAllDto> {
        return listOf(
            UserGetAllDto(
                id = 1L,
                name = "山田 太郎",
                email = "taro@example.com"
            ),
            UserGetAllDto(
                id = 2L,
                name = "佐藤 花子",
                email = "hanako@example.com"
            )
        )
    }
}