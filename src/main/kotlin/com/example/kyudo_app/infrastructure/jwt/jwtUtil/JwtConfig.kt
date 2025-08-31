package com.example.kyudo_app.infrastructure.jwt.jwtUtil

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import javax.crypto.spec.SecretKeySpec
import com.nimbusds.jose.jwk.source.ImmutableSecret
import javax.crypto.SecretKey

@Configuration
class JwtConfig {

    private val secret: SecretKey = SecretKeySpec("super-secret-key-that-is-long-enough".toByteArray(), "HmacSHA256")

    @Bean
    fun jwtEncoder(): JwtEncoder {
        return NimbusJwtEncoder(ImmutableSecret(secret))
    }

    @Bean
    fun jwtDecoder(): JwtDecoder {
        return NimbusJwtDecoder.withSecretKey(secret).build()
    }
}
