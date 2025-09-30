package com.example.kyudo_app.infrastructure.jwt

import com.example.kyudo_app.infrastructure.service.CustomUserDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtUtil: JwtUtil,
    private val userDetailsService: CustomUserDetailsService
) : OncePerRequestFilter() {

    // JWT不要のパス
    private val permitPaths = listOf("/auth/", "/user/login", "/user/register")

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val path = request.requestURI

        // OPTIONS は常にスルー（プリフライト対策）
        if (request.method == "OPTIONS") {
            filterChain.doFilter(request, response)
            return
        }

        // 許可パスはスルー
        if (permitPaths.any { path.startsWith(it) }) {
            filterChain.doFilter(request, response)
            return
        }

        // JWT チェック
        val header = request.getHeader("Authorization")
        if (header == null || !header.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
            return
        }

        val token = header.substring(7)
        if (!jwtUtil.validateToken(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
            return
        }

        val userId = jwtUtil.getUserIdFromToken(token)
        val userDetails = userDetailsService.loadUserByUserId(userId)

        val authentication = UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            userDetails.authorities
        )
        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authentication

        filterChain.doFilter(request, response)
    }
}
