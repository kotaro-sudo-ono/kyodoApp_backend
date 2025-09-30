package com.example.kyudo_app.infrastructure.service

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    private val userId: String,
    private val username: String,
    private val password: String,
    private val authorities: List<GrantedAuthority>
) : UserDetails {

    override fun getUsername() = username
    override fun getPassword() = password
    override fun getAuthorities() = authorities
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true

    fun getUserId() = userId
}
