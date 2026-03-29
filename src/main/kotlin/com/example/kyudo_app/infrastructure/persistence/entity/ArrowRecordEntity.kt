package com.example.kyudo_app.infrastructure.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "arrow_record")
@EntityListeners(EntityListener::class)
class ArrowRecordEntity(

    @Id
    @Column(name = "arrow_id")
    var arrowId: String? = null,

    @Column(name = "arrow_no")
    var arrowNo: Int? = null,

    @Column(name = "hit")
    var hit: Boolean? = null,

    @Column(name = "position_x")
    var positionX: Double? = null,

    @Column(name = "position_y")
    var positionY: Double? = null,

    @Column(name = "game_match_user_id")
    var gameMatchUserId: String? = null,

    @Column(name = "team_match_member_id")
    var teamMatchMemberId: String? = null,

    @Column(name = "remarks")
    var remarks: String? = null,

    @Column(name = "stand_number")
    var standNumber: Int? = null,

    @ManyToOne
    @JoinColumn(name = "record_id")
    var record: RecordEntity? = null
)
