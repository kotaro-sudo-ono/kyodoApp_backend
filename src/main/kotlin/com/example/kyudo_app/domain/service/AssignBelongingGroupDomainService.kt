package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.repository.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class AssignBelongingGroupDomainService(
    private val userRepository: UserRepositoryPort
) {

    fun assignGroupToUserEntity(userId: String?, groupId: String?) {
        val user = userRepository.findById(userId ?: throw IllegalArgumentException("Invalid user ID: $userId"))
            ?: throw IllegalArgumentException("Invalid user ID: $userId")
        userRepository.save(user)
    }
}
