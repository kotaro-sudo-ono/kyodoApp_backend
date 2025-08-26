package com.example.kyudo_app.infrastructure.persistence

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import java.util.*

@Setter
@Getter
@Entity
@Table(name = "game_match")
class GameMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private var matchId: Long? = null

    @Column(name = "match_date")
    private var matchDate: Date? = null

    @ManyToMany
    @JoinTable(
        name = "GameMatch_User",
        joinColumns = [JoinColumn(name = "match_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    private val users: MutableList<User?>? = null // GameMatchに関連する複数のユーザー

    @ManyToOne
    @JoinColumn(name = "Place_id", referencedColumnName = "Place_id")
    private val place: Place? = null
}
