package com.example.kyudo_app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
open class CorsConfig {
    @Bean
    open fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        config.setAllowedOrigins(mutableListOf<String?>("http://localhost:5173")) // フロントエンドのオリジンを許可
        config.setAllowedMethods(mutableListOf<String?>("GET", "POST", "PUT", "DELETE", "OPTIONS")) // 許可するメソッド
        config.setAllowedHeaders(mutableListOf<String?>("*")) // すべてのヘッダーを許可
        config.setAllowCredentials(true) // クッキーや認証情報を許可

        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}