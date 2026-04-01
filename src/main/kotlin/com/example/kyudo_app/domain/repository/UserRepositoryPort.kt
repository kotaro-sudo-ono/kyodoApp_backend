package com.example.kyudo_app.domain.repository

import com.example.kyudo_app.domain.model.User

interface UserRepositoryPort {
    fun save(user: User): User
    fun findById(id: String): User?
    fun findByEmail(email: String): User?
}
