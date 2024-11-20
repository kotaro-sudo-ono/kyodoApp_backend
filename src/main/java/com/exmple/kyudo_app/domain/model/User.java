package com.exmple.kyudo_app.domain.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "mail_address")
    private String email;

    @Column(name = "lore_id")
    private Integer userRole;

    @ManyToMany(mappedBy = "users")
    private List<GameMatch> gameMatches;

    @OneToMany(mappedBy = "user")
    private List<Record> records;

    @OneToMany(mappedBy = "user")
    private List<TeamMember> teamMembers;

    @OneToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private BelongingGroup belongingGroup;
}
