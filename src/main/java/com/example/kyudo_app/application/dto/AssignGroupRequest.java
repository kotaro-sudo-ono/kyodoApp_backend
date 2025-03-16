package com.example.kyudo_app.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignGroupRequest {
    private Long groupId;
    private Long userId;
}