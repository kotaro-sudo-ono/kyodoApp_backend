package com.exmple.kyudo_app.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="team_member")
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "team_member_id")
    private Long teamMemberId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName  = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;
}
