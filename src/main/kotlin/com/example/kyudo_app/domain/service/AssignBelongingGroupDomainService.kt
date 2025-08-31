package com.example.kyudo_app.domain.service

import com.example.kyudo_app.infrastructure.persistence.repository.AssignBelongingGroupRepository
import com.example.kyudo_app.infrastructure.persistence.repository.UserRegisterRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AssignBelongingGroupDomainService(
    private val assignBelongingGroupRepository: AssignBelongingGroupRepository,
    private val userRegisterRepository: UserRegisterRepository
) {
    // group_idを使ってBelongingGroupを取得し、関連するエンティティにセット
    fun assignGroupToUserEntity(userId: Int?, groupId: Int?) {

        val user = userRegisterRepository.findByIdOrNull(userId)
            ?: throw IllegalArgumentException("Invalid user ID: $userId")

        userRegisterRepository.save(user)
    }
}
