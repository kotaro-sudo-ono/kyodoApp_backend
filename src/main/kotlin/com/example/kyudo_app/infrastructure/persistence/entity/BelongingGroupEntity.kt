package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "belonging_group")
@EntityListeners(EntityListener::class)
class BelongingGroupEntity(
    @Id
    @Column(name = "group_id")
    var id: String? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @OneToMany(mappedBy = "belongingGroup")
    val users: MutableList<UserEntity> = mutableListOf()
)
