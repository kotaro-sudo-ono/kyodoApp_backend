package com.exmple.kyudo_app.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="TeamMember")
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamMemberId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName  = "userId")
    private User user;
    @OneToOne
    @JoinColumn(name = "teamId", referencedColumnName = "teamId")
    private Team team;
}
