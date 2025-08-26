package com.example.kyudo_app.domain.model

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Setter
@Getter
@Entity
@Table(name = "record")
class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recode_id")
    private var recodeId: Long? = null

    @Column(name = "hit_count")
    private var hitCount: Int? = null

    @Column(name = "total_shots")
    private var totalShots: Int? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private val user: User? = null
}

