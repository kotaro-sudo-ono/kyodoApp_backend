package com.example.kyudo_app.domain.service;

import com.example.kyudo_app.domain.model.BelongingGroup;
import com.example.kyudo_app.domain.model.User;
import com.example.kyudo_app.infrastructure.external.AssignBelongingGroupRepository;
import com.example.kyudo_app.infrastructure.external.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignBelongingGroupService {

    @Autowired
    private AssignBelongingGroupRepository assignBelongingGroupRepository;
    @Autowired
    private UserRegisterRepository userRegisterRepository;

    // group_idを使ってBelongingGroupを取得し、関連するエンティティにセット
    public void assignGroupToUserEntity(Long userId, Long groupId) {
        BelongingGroup belongingGroup = assignBelongingGroupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group ID: " + groupId));

        User user = userRegisterRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));

        user.setBelongingGroup(belongingGroup);
        userRegisterRepository.save(user);
    }
    }

