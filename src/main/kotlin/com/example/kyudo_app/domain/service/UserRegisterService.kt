package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.infrastructure.external.UserRegisterRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.repository.findByIdOrNull

@Service
class UserRegisterService(
    private val userRegisterRepository: UserRegisterRepository
) {
    @Transactional
    fun registryUser(user: User): User {
        return userRegisterRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUserById(id: Long): User {
        return userRegisterRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("User not found for id=$id")
    }
}
