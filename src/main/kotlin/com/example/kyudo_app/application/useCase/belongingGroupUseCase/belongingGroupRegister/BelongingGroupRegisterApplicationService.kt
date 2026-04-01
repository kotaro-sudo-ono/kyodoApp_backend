package com.example.kyudo_app.application.useCase.belongingGroupUseCase.belongingGroupRegister

import com.example.kyudo_app.domain.model.BelongingGroup
import com.example.kyudo_app.domain.service.BelongingGroupRegisterDomainService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BelongingGroupRegisterApplicationService(
    private val belongingGroupRegisterDomainService: BelongingGroupRegisterDomainService
) : BelongingGroupRegisterUseCase {

    @Transactional
    override fun register(command: BelongingGroupRegisterCommand): BelongingGroupRegisterDto {
        val group = BelongingGroup(groupId = null, name = command.name)
        val saved = belongingGroupRegisterDomainService.registerBelongingGroup(group)
        return BelongingGroupRegisterDto(groupId = saved.groupId, name = saved.name)
    }
}
