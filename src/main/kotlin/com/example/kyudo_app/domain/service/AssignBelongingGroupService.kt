package com.example.kyudo_app.domain.service

import com.example.kyudo_app.infrastructure.external.AssignBelongingGroupRepository
import com.example.kyudo_app.infrastructure.external.UserRegisterRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AssignBelongingGroupService(
    private val assignBelongingGroupRepository: AssignBelongingGroupRepository,
    private val userRegisterRepository: UserRegisterRepository
) {
    // group_idを使ってBelongingGroupを取得し、関連するエンティティにセット
    fun assignGroupToUserEntity(userId: Long, groupId: Long?) {
        val belongingGroup = assignBelongingGroupRepository.findByIdOrNull(groupId)
            ?: throw IllegalArgumentException("指定されたグループが存在しません: $groupId")

        val user = userRegisterRepository.findByIdOrNull(userId)
            ?: throw IllegalArgumentException("Invalid user ID: $userId")

        user.setBelongingGroup(belongingGroup)
        userRegisterRepository.save(user)
    }
}
