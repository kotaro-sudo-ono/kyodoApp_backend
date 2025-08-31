package com.example.kyudo_app.infrastructure.jwt.jwtUtil

import org.springframework.beans.factory.annotation.Value

import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class JwtUtil(
    @Value("\${jwt.expiration}") private val expirationMillis: Long,
    private val jwtEncoder: JwtEncoder,
    private val jwtDecoder: JwtDecoder
) {

    /** JWT の生成 */
    fun generateToken(userName: String): String {
        val now = Instant.now()
        val expiry = now.plusMillis(expirationMillis)

        val claims = JwtClaimsSet.builder()
            .subject(userName)
            .issuedAt(now)
            .expiresAt(expiry)
            .claim("sub", userName) // 任意のクレームを追加
            .build()

        val parameters = JwtEncoderParameters.from(claims)
        val jwt = jwtEncoder.encode(parameters)


        return jwt.tokenValue
    }

    /** JWT からユーザ名を取得 */
    fun getUserNameFromToken(token: String): String {
        val jwt = jwtDecoder.decode(token)
        return jwt.claims["sub"] as String
    }

    /** JWT の検証 */
    fun validateToken(token: String): Boolean {
        return try {
            jwtDecoder.decode(token)
            true
        } catch (ex: Exception) {
            false
        }
    }
}
