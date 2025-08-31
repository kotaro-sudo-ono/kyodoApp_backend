package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "place")
class PlaceEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    val id: Int? = null,

    @Column(name = "place_name", nullable = false)
    var name: String,

    @Column(name = "address")
    var address: String? = null,

    @OneToMany(mappedBy = "place")
    val gameMatches: MutableList<GameMatchEntity> = mutableListOf()
)
