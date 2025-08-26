package com.example.kyudo_app.infrastructure.persistence

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Setter
@Getter
@Entity
@Table(name = "belonging_group")
class BelongingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private var groupId: Long? = null

    @Column(name = "name")
    private var name: String? = null
}
