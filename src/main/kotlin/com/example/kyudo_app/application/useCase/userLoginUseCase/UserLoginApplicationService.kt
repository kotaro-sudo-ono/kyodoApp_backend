package com.example.kyudo_app.application.useCase.userLoginUseCase

import com.example.kyudo_app.infrastructure.jwt.JwtUtil
import com.example.kyudo_app.infrastructure.persistence.repository.UserRepository
import com.example.kyudo_app.infrastructure.security.PasswordEncoder
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserLoginApplicationService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
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
        val jwtToken = jwtUtil.generateToken(user.email, user.id!!)

        return UserLoginDto(jwtToken)
    }
}