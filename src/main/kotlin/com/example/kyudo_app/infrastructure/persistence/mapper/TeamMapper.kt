package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.Team
import com.example.kyudo_app.infrastructure.persistence.entity.TeamEntity

object TeamMapper {

    fun toEntity(domain: Team): TeamEntity {
        return TeamEntity(
            id = domain.teamId,
            name = domain.teamName
        )
    }

    fun toDomain(entity: TeamEntity): Team {
        return Team(
            teamId = entity.id,
            teamName = entity.name
        )
    }
}
