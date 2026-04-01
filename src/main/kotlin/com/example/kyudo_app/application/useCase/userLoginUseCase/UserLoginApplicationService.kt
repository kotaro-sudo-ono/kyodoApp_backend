package com.example.kyudo_app.application.useCase.userLoginUseCase

import com.example.kyudo_app.domain.repository.UserRepositoryPort
import com.example.kyudo_app.domain.service.PasswordEncoderPort
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserLoginApplicationService(
    private val userRepository: UserRepositoryPort,
    private val passwordEncoder: PasswordEncoderPort,
    private val tokenGenerator: TokenGeneratorPort
) : UserLoginUseCase {

    override fun login(param: UserLoginParam): UserLoginDto {
        // ユーザー取得
        val user = userRepository.findByEmail(param.email)
            ?: throw UsernameNotFoundException("User not found: ${param.email}")

        // パスワード照合
        if (!passwordEncoder.matches(param.password, user.password)) {
            throw BadCredentialsException("Invalid password")
        }

        // JWT 発行
        val jwtToken = tokenGenerator.generateToken(user.email, user.userId!!)

        return UserLoginDto(jwtToken)
    }
}
