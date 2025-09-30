package com.example.kyudo_app.application.useCase.getUserByIdUseCase

import org.springframework.stereotype.Service

@Service
class UserGetByIdApplicationService : UserGetByIdUseCase {
    override fun getById(param: GetUserByIdParam): UserGetByIdDto? {
        // リポジトリ未実装なので仮のデータ返却
        return if (param.userId == "1") {
            UserGetByIdDto(
                userId = "1",
                name = "テストユーザー",
                email = "test@example.com"
            )
        } else {
            null
        }
    }
}