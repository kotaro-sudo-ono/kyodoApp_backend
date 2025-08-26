package com.example.kyudo_app.infrastructure.persistence

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Setter
@Getter
@Entity
@Table(name = "team_member")
class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_member_id")
    private var teamMemberId: Long? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private val user: User? = null

    @OneToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private val team: Team? = null
}
