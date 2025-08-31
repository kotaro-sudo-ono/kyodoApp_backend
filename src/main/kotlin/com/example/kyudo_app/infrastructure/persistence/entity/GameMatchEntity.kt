package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "game_match")
class GameMatchEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    val id: Int? = null,

    @Column(name = "match_date")
    var matchDate: Date? = null,

    @ManyToMany
    @JoinTable(
        name = "game_match_user",
        joinColumns = [JoinColumn(name = "match_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    val users: MutableList<UserEntity> = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id")
    var place: PlaceEntity? = null
)
