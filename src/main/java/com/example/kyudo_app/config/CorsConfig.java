package com.example.kyudo_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // フロントエンドのオリジンを許可
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 許可するメソッド
        config.setAllowedHeaders(Arrays.asList("*")); // すべてのヘッダーを許可
        config.setAllowCredentials(true); // クッキーや認証情報を許可

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}