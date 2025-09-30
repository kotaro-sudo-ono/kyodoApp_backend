package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "team")
@EntityListeners(EntityListener::class)
class TeamEntity(

    @Id
    @Column(name = "team_id")
    var id: String? = null,

    @Column(name = "team_name", nullable = false)
    val name: String
)
