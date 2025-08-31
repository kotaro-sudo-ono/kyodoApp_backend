package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.*
import com.example.kyudo_app.infrastructure.persistence.entity.*

object UserMapper {

    fun toEntity(domain: User): UserEntity {
        return UserEntity(
            id = domain.userId,
            name = domain.name,
            email = domain.email,
            userRole = domain.userRole,
            password = domain.password,
            belongingGroup = domain.belongingGroup?.let { BelongingGroupMapper.toEntity(it) },
            // コレクションはエンティティに変換
            gameMatches = domain.gameMatches.map { GameMatchMapper.toEntity(it) }.toMutableList(),
            records = domain.records.map { RecordMapper.toEntity(it) }.toMutableList(),
            teamMembers = domain.teamMembers.map { TeamMemberMapper.toEntity(it) }.toMutableList()
        )
    }

    fun toDomain(entity: UserEntity): User {
        return User(
            userId = entity.id, // Entity は nullable なので fallback
            name = entity.name,
            email = entity.email,
            userRole = entity.userRole ?: 0,
            password = entity.password,
            belongingGroup = entity.belongingGroup?.let { BelongingGroupMapper.toDomain(it) },
            // コレクションをドメインに変換
            gameMatches = entity.gameMatches.map { it.let { GameMatchMapper.toDomain(it) } },
            records = entity.records.map { it.let { RecordMapper.toDomain(it) } },
            teamMembers = entity.teamMembers.map { it.let { TeamMemberMapper.toDomain(it) } }
        )
    }
}
