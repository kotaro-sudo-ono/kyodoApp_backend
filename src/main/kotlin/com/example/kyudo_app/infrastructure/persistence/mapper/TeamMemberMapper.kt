package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.TeamMember
import com.example.kyudo_app.infrastructure.persistence.entity.TeamMemberEntity

object TeamMemberMapper {

    fun toEntity(domain: TeamMember): TeamMemberEntity {
        return TeamMemberEntity(
            id = if (domain.teamMemberId == 0L) null else domain.teamMemberId, // 新規なら null
            user = UserMapper.toEntity(domain.user),
            team = TeamMapper.toEntity(domain.team)
        )
    }

    fun toDomain(entity: TeamMemberEntity): TeamMember {
        return TeamMember(
            teamMemberId = entity.id ?: 0L,
            user = UserMapper.toDomain(entity.user!!),   // null じゃない前提
            team = TeamMapper.toDomain(entity.team!!)   // null じゃない前提
        )
    }
}
