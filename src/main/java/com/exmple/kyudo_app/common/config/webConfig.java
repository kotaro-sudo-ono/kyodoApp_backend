package com.exmple.kyudo_app.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // すべてのエンドポイントにCORS設定
                .allowedOrigins("http://localhost:5173")  // フロントエンドのURL（CORSを許可するオリジン）
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 許可するHTTPメソッド
                .allowedHeaders("*")  // 許可するヘッダー
                .allowCredentials(true);  // Cookieや認証情報を含める場合はtrue
    }
}
