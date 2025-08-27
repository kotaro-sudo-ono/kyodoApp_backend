package com.example.kyudo_app.application.useCase.GetUserByIdUseCase

import org.springframework.stereotype.Service

@Service
class UserGetByIdService : UserGetByIdUseCase {
    override fun getById(param: GetUserByIdParam): UserGetByIdDto? {
        // リポジトリ未実装なので仮のデータ返却
        return if (param.userId == 1L) {
            UserGetByIdDto(
                userId = 1L,
                name = "テストユーザー",
                email = "test@example.com"
            )
        } else {
            null
        }
    }
}