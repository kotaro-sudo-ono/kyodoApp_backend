package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.Team
import com.example.kyudo_app.infrastructure.persistence.entity.TeamEntity

object TeamMapper {

    fun toEntity(domain: Team): TeamEntity {
        return TeamEntity(
            id = if (domain.teamId == 0L) null else domain.teamId,
            name = domain.teamName
        )
    }

    fun toDomain(entity: TeamEntity): Team {
        return Team(
            teamId = entity.id ?: 0L,
            teamName = entity.name
        )
    }
}
