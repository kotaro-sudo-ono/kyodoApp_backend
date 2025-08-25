package com.example.kyudo_app.presentation.controller

import com.example.kyudo_app.application.dto.AssignGroupRequest
import com.example.kyudo_app.domain.model.BelongingGroup
import com.example.kyudo_app.domain.service.AssignBelongingGroupService
import com.example.kyudo_app.domain.service.BelongingGroupResisterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/belongingGroup")
class BelongingGroupController(
    private val belongingGroupResisterService: BelongingGroupResisterService,
    private val assignBelongingGroupService: AssignBelongingGroupService
) {

    @PostMapping("/register")
    fun registerBelongingGroup(@RequestBody belongingGroup: BelongingGroup): ResponseEntity<BelongingGroup> {
        val registered = belongingGroupResisterService.registerBelongingGroup(belongingGroup)
        return ResponseEntity.ok(registered)
    }

    @PostMapping("/assign-group")
    fun assignGroup(@RequestBody assignGroupRequest: AssignGroupRequest): ResponseEntity<String> {
        return try {
            assignGroupRequest.userId.let {
                assignBelongingGroupService.assignGroupToUserEntity(
                    it,
                    assignGroupRequest.groupId
                )
            }
            ResponseEntity.ok("Group assigned successfully")
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error assigning group: ${e.message}")
        }
    }
}
