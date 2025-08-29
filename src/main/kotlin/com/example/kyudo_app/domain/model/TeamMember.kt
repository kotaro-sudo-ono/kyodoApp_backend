package com.example.kyudo_app.domain.model


class TeamMember(
    val teamMemberId: Long,
    val user: User,
    val team: Team
)