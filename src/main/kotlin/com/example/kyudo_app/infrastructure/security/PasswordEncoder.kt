package com.example.kyudo_app.infrastructure.security

import com.example.kyudo_app.domain.service.PasswordEncoderPort
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoder : PasswordEncoderPort {
    
    private val encoder = BCryptPasswordEncoder()
    
    override fun encode(rawPassword: String): String {
        return encoder.encode(rawPassword)
    }

    override fun matches(rawPassword: String, encodedPassword: String): Boolean {
        return encoder.matches(rawPassword, encodedPassword)
    }
}
