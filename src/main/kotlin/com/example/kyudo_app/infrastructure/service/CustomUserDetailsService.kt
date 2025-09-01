package com.example.kyudo_app.infrastructure.service

import com.example.kyudo_app.infrastructure.persistence.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService (
    private val userRepository: UserRepository
): UserDetailsService  {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByName(username)
            ?: throw UsernameNotFoundException("User not found: $username")
        return CustomUserDetails(
            user.id!!,
            username = user.name,
            password = user.password,
            authorities = listOf(SimpleGrantedAuthority(user.userRole?.let { mapRole(it) }))
        )
    }

    // JWT の subject (userId) で取得
    fun loadUserByUserId(userId: String): UserDetails {
        val user = userRepository.findById(userId)
            .orElseThrow { UsernameNotFoundException("User not found: $userId") }

        return CustomUserDetails(
            user.id!!,
            username = user.name,
            password = user.password,
            authorities = listOf(SimpleGrantedAuthority(user.userRole?.let { mapRole(it) }))
        )
    }

    private fun mapRole(role: Int): String {
        return when (role) {
            0 -> "ROLE_USER"
            1 -> "ROLE_ADMIN"
            else -> "ROLE_GUEST"
        }
    }
}