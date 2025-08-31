package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "belonging_group")
class BelongingGroupEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    val id: Int? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @OneToMany(mappedBy = "belongingGroup")
    val users: MutableList<UserEntity> = mutableListOf()
)
