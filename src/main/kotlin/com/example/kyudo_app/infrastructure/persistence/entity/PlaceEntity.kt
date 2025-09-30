package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "place")
@EntityListeners(EntityListener::class)
class PlaceEntity(

    @Id
    @Column(name = "place_id")
    var id: String? = null,

    @Column(name = "place_name", nullable = false)
    var name: String,

    @Column(name = "address")
    var address: String? = null,

    @OneToMany(mappedBy = "place")
    val gameMatches: MutableList<GameMatchEntity> = mutableListOf()
)
