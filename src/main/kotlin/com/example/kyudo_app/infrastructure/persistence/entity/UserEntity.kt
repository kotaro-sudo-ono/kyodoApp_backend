package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
@EntityListeners(EntityListener::class)
class UserEntity(

    @Id
    @Column(name = "user_id")
    var id: String? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "mail_address")
    var email: String,

    @Column(name = "role_id")
    var userRole: Int? = null,

    @Column(name = "password", nullable = false)
    var password: String,

    @ManyToMany(mappedBy = "users")
    val gameMatches: MutableList<GameMatchEntity> = mutableListOf(),

    @OneToMany(mappedBy = "user")
    val records: MutableList<RecordEntity> = mutableListOf(),

    @OneToMany(mappedBy = "user")
    val teamMembers: MutableList<TeamMemberEntity> = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    var belongingGroup: BelongingGroupEntity? = null
){
    // Hibernate が使う引数なしコンストラクタ
    protected constructor() : this(
        id = null,
        name = "",
        email = "",
        userRole = null,
        password = "",
        gameMatches = mutableListOf(),
        records = mutableListOf(),
        teamMembers = mutableListOf(),
        belongingGroup = null
    )
}
