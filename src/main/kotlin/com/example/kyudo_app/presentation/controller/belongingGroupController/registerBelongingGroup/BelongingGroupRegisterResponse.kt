package com.example.kyudo_app.presentation.controller.belongingGroupController.registerBelongingGroup

import com.example.kyudo_app.application.useCase.belongingGroupUseCase.belongingGroupRegister.BelongingGroupRegisterDto

data class BelongingGroupRegisterResponse(
    val groupId: String?,
    val name: String
) {
    companion object {
        fun from(dto: BelongingGroupRegisterDto): BelongingGroupRegisterResponse =
            BelongingGroupRegisterResponse(groupId = dto.groupId, name = dto.name)
    }
}
