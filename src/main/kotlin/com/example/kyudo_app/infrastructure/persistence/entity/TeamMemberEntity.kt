package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "team_member")
class TeamMemberEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_member_id")
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    var user: UserEntity? = null,

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    var team: TeamEntity? = null
)
