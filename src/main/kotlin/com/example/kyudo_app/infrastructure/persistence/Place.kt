package com.example.kyudo_app.infrastructure.persistence

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Setter
@Getter
@Entity
@Table(name = "Place")
class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private var placeId: Int? = null

    @Column(name = "place_name")
    private var placeName: String? = null

    @Column(name = "address")
    private var placePoint: String? = null

    // Placeに関連するゲームマッチ（複数のGameMatch）
    @OneToMany(mappedBy = "place")
    private val gameMatches: MutableList<GameMatch?>? = null
}
