package com.example.kyudo_app.application.useCase.belongingGroupUseCase.belongingGroupRegister

interface BelongingGroupRegisterUseCase {
    fun register(command: BelongingGroupRegisterCommand): BelongingGroupRegisterDto
}
