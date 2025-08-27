package com.example.kyudo_app.application.useCase.UserLoginUseCase

import org.springframework.stereotype.Service

@Service
class UserLoginService : UserLoginUseCase {

    override fun login(param: UserLoginParam): UserLoginDto {
        // ここで認証ロジックを書く（例：DBでユーザー確認、パスワード検証）
        // 成功したらJWT発行
        val jwtToken = "dummy_jwt_token" // 本当はJWT生成ロジックを呼ぶ

        return UserLoginDto(jwtToken)
    }
}