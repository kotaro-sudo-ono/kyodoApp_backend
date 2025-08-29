package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "belonging_group")
class BelongingGroupEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    val id: Long,

    @Column(name = "name", nullable = false)
    val name: String
)
