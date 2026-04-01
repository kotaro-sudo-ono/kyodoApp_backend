package com.example.kyudo_app.application.useCase.belongingGroupUseCase.assignGroup

import com.example.kyudo_app.domain.service.AssignBelongingGroupDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AssignGroupApplicationService(
    private val assignBelongingGroupDomainService: AssignBelongingGroupDomainService
) : AssignGroupUseCase {

    @Transactional
    override fun assign(command: AssignGroupCommand) {
        assignBelongingGroupDomainService.assignGroupToUserEntity(command.userId, command.groupId)
    }
}
