package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "record")
@EntityListeners(EntityListener::class)
class RecordEntity(

    @Id
    @Column(name = "record_id")
    var id: String? = null,

    @Column(name = "hit_count")
    var hitCount: Int? = null,

    @Column(name = "total_shots")
    var totalShots: Int? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    var user: UserEntity? = null,

    @Column(name = "practice_date")
    var practiceDate: java.time.LocalDateTime? = null,

    @Column(name = "practice_type_id")
    var practiceTypeId: Int? = null,

    @OneToMany(mappedBy = "record", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var arrows: MutableList<ArrowRecordEntity> = mutableListOf()
)
