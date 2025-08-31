package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Int? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "mail_address", nullable = false)
    var email: String,

    @Column(name = "role_id")
    var userRole: Int? = null,

    @ManyToMany(mappedBy = "users")
    val gameMatches: MutableList<GameMatchEntity> = mutableListOf(),

    @OneToMany(mappedBy = "user")
    val records: MutableList<RecordEntity> = mutableListOf(),

    @OneToMany(mappedBy = "user")
    val teamMembers: MutableList<TeamMemberEntity> = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    var belongingGroup: BelongingGroupEntity? = null
)
