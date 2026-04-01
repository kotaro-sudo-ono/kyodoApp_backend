package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.domain.repository.UserRepositoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserRegisterDomainService(
    private val userRepository: UserRepositoryPort
) {

    @Transactional
    fun registerUser(domainUser: User): User = userRepository.save(domainUser)

    @Transactional(readOnly = true)
    fun getUserById(id: String?): User {
        requireNotNull(id) { "id must not be null" }
        return userRepository.findById(id)
            ?: throw IllegalArgumentException("User not found for id=$id")
    }
}
