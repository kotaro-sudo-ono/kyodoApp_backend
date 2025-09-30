package com.example.kyudo_app.domain.service

import com.example.kyudo_app.infrastructure.persistence.repository.AssignBelongingGroupRepository
import com.example.kyudo_app.infrastructure.persistence.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AssignBelongingGroupDomainService(
    private val assignBelongingGroupRepository: AssignBelongingGroupRepository,
    private val userRegisterRepository: UserRepository
) {
    // group_idを使ってBelongingGroupを取得し、関連するエンティティにセット
    fun assignGroupToUserEntity(userId: String?, groupId: String?) {

        val user = userRegisterRepository.findByIdOrNull(userId)
            ?: throw IllegalArgumentException("Invalid user ID: $userId")

        userRegisterRepository.save(user)
    }
}
