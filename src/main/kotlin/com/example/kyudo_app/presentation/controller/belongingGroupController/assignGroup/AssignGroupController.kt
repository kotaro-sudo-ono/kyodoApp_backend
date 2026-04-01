package com.example.kyudo_app.presentation.controller.belongingGroupController.assignGroup

import com.example.kyudo_app.application.useCase.belongingGroupUseCase.assignGroup.AssignGroupCommand
import com.example.kyudo_app.application.useCase.belongingGroupUseCase.assignGroup.AssignGroupUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/belongingGroup")
@CrossOrigin(origins = ["http://localhost:5173"])
class AssignGroupController(
    private val assignGroupUseCase: AssignGroupUseCase
) {

    @PostMapping("/assign-group")
    fun assignGroup(@RequestBody request: AssignGroupRequest): ResponseEntity<String> {
        assignGroupUseCase.assign(AssignGroupCommand(userId = request.userId, groupId = request.groupId))
        return ResponseEntity.ok("Group assigned successfully")
    }
}
