package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "record")
class RecordEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    val id: Int? = null,

    @Column(name = "hit_count")
    var hitCount: Int? = null,

    @Column(name = "total_shots")
    var totalShots: Int? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    var user: UserEntity? = null
)
