package com.example.kyudo_app.application.useCase.UserRegisterUseCase

import com.example.kyudo_app.domain.model.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserRegisterApplicationService: UserRegisterUseCase {

    @Transactional
    override fun register(request: UserRegisterParam): UserRegisterDto {
        // ここでUserエンティティを作成するなどビジネスロジックを書く
        val user = User(
            userId = "1",
            name = request.name,
            email = request.email,
            userRole = 1
        )

        return UserRegisterDto.from(user)
    }
}