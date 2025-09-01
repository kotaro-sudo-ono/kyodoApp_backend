package com.example.kyudo_app.infrastructure.jwt

import com.example.kyudo_app.infrastructure.service.CustomUserDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter

class JwtAuthenticationFilter (
    private val jwtUtil: JwtUtil,
    private val userDetailsService: CustomUserDetailsService
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader("Authorization")
        if(header != null && header.startsWith("Bearer ")) {
            val token = header.substring(7)
            if(jwtUtil.validateToken(token)) {
                val userId = jwtUtil.getUserIdFromToken(token)
                val userDetails = userDetailsService.loadUserByUserId (userId)

                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)

                SecurityContextHolder.getContext().authentication = authentication
            }
        }
        filterChain.doFilter(request, response)

    }
}