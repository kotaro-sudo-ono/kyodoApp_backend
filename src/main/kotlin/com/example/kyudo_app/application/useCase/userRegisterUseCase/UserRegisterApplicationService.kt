package com.example.kyudo_app.application.useCase.userRegisterUseCase

import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.domain.service.PasswordEncoderPort
import com.example.kyudo_app.domain.service.UserRegisterDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserRegisterApplicationService(
    private val userRegisterDomainService: UserRegisterDomainService,
    private val passwordEncoder: PasswordEncoderPort
): UserRegisterUseCase {

    @Transactional
    override fun register(request: UserRegisterParam): UserRegisterDto {
        // パスワードをハッシュ化
        val hashedPassword = passwordEncoder.encode(request.rawPassword)
        
        // ドメインモデルを作成
        val user = User(
            userId = null, // ULIDは自動生成される
            name = request.name,
            email = request.email,
            userRole = 1, // デフォルトロール
            password = hashedPassword
        )

        // ドメインサービスを使用してユーザーを登録
        val savedUser = userRegisterDomainService.registerUser(user)

        return UserRegisterDto.from(savedUser)
    }
}
