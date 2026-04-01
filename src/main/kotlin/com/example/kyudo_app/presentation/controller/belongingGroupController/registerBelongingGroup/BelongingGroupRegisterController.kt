package com.example.kyudo_app.presentation.controller.belongingGroupController.registerBelongingGroup

import com.example.kyudo_app.application.useCase.belongingGroupUseCase.belongingGroupRegister.BelongingGroupRegisterCommand
import com.example.kyudo_app.application.useCase.belongingGroupUseCase.belongingGroupRegister.BelongingGroupRegisterUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/belongingGroup")
@CrossOrigin(origins = ["http://localhost:5173"])
class BelongingGroupRegisterController(
    private val belongingGroupRegisterUseCase: BelongingGroupRegisterUseCase
) {

    @PostMapping("/register")
    fun registerBelongingGroup(
        @RequestBody request: BelongingGroupRegisterRequest
    ): ResponseEntity<BelongingGroupRegisterResponse> {
        val command = BelongingGroupRegisterCommand(name = request.name)
        val dto = belongingGroupRegisterUseCase.register(command)
        return ResponseEntity.ok(BelongingGroupRegisterResponse.from(dto))
    }
}
