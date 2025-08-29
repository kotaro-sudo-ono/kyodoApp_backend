package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.GameMatch
import com.example.kyudo_app.infrastructure.persistence.entity.GameMatchEntity

object GameMatchMapper {

    fun toEntity(domain: GameMatch): GameMatchEntity {
        val entity = GameMatchEntity()
        entity.id = domain.matchId
        entity.matchDate = domain.matchDate
        entity.place = domain.place?.let { PlaceMapper.toEntity(it) }
        entity.users = domain.users.map { UserMapper.toEntity(it) }.toMutableList()
        return entity
    }

    fun toDomain(entity: GameMatchEntity): GameMatch {
        return GameMatch(
            matchId = entity.id ?: 0L,
            matchDate = entity.matchDate ?: java.util.Date(),
            place = entity.place?.let { PlaceMapper.toDomain(it) },
            users = entity.users.map { UserMapper.toDomain(it) }
        )
    }
}
