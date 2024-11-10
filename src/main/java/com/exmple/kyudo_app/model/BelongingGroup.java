package com.exmple.kyudo_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="BelongingGroup")
public class BelongingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;
}
