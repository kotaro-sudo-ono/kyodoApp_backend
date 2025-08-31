package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.GameMatch
import com.example.kyudo_app.infrastructure.persistence.entity.GameMatchEntity

object GameMatchMapper {

    fun toEntity(domain: GameMatch): GameMatchEntity {
        return GameMatchEntity(
            id = domain.matchId,
            matchDate = domain.matchDate,
            place = domain.place?.let { PlaceMapper.toEntity(it) },
            users = domain.users.map { UserMapper.toEntity(it) }.toMutableList()
        )
    }

    fun toDomain(entity: GameMatchEntity): GameMatch {
        return GameMatch(
            matchId = entity.id,
            matchDate = entity.matchDate ?: java.util.Date(),
            place = entity.place?.let { PlaceMapper.toDomain(it) },
            users = entity.users.map { UserMapper.toDomain(it) }
        )
    }
}
