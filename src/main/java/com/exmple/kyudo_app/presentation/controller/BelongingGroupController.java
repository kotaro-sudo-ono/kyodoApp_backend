package com.exmple.kyudo_app.presentation.controller;

import com.exmple.kyudo_app.application.dto.AssignGroupRequest;
import com.exmple.kyudo_app.domain.model.BelongingGroup;
import com.exmple.kyudo_app.domain.service.AssignBelongingGroupService;
import com.exmple.kyudo_app.domain.service.BelongingGroupResisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/belongingGroup")
public class BelongingGroupController {

    @Autowired
    private AssignBelongingGroupService assignBelongingGroupService;

    private final BelongingGroupResisterService belongingGroupResisterService;

    public BelongingGroupController(BelongingGroupResisterService belongingGroupResisterService){
        this.belongingGroupResisterService = belongingGroupResisterService;
    }

    @PostMapping("/register")
    public ResponseEntity<BelongingGroup> registerBelongingGroup(@RequestBody BelongingGroup belongingGroup){
        BelongingGroup registerBelongingGroup = belongingGroupResisterService.registerBelongingGroup(belongingGroup);
        return ResponseEntity.ok(registerBelongingGroup);
    }

    @PostMapping("/assign-group")
    public ResponseEntity<String> assignGroup(@RequestBody AssignGroupRequest assignGroupRequest){
        try{
            assignBelongingGroupService.assignGroupToUserEntity(assignGroupRequest.getGroupId(), assignGroupRequest.getUserId());
            return ResponseEntity.ok("Group assigned successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error assigning group: " + e.getMessage());
        }
    }
}
