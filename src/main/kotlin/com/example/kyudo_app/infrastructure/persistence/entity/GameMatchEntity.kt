package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "game_match")
class GameMatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    var id: Long? = null

    @Column(name = "match_date")
    var matchDate: Date? = null

    @ManyToMany
    @JoinTable(
        name = "GameMatch_User",
        joinColumns = [JoinColumn(name = "match_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    var users: MutableList<UserEntity> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id")
    var place: PlaceEntity? = null
}
