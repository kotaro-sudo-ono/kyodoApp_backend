package com.example.kyudo_app.infrastructure.persistence

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter


@Setter
@Getter
@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private var userId: Long? = null

    @Column(name = "name")
    private var name: String? = null

    @Column(name = "mail_address")
    private var email: String? = null

    @Column(name = "lore_id")
    private var userRole: Int? = null

    @ManyToMany(mappedBy = "users")
    private val gameMatches: MutableList<GameMatch?>? = null

    @OneToMany(mappedBy = "user")
    private val records: MutableList<Record?>? = null

    @OneToMany(mappedBy = "user")
    private val teamMembers: MutableList<TeamMember?>? = null

    @OneToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private var belongingGroup: BelongingGroup? = null

    fun setBelongingGroup(belongingGroup: BelongingGroup?) {
        this.belongingGroup = belongingGroup
    }
}
