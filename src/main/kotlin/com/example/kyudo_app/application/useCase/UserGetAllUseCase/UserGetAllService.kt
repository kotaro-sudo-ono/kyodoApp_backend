package com.example.kyudo_app.application.useCase.UserGetAllUseCase

import lombok.`val`
import org.springframework.stereotype.Service

@Service
class UserGetAllService : UserGetAllUseCase {

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