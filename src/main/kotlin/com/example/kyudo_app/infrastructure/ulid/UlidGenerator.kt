package com.example.kyudo_app.infrastructure.ulid

import com.github.f4b6a3.ulid.UlidCreator
import org.springframework.stereotype.Component

@Component
class UlidGenerator {
    
    fun generate(): String {
        return UlidCreator.getUlid().toString()
    }
    
    companion object {
        fun generateStatic(): String {
            return UlidCreator.getUlid().toString()
        }
    }
}
