package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.BelongingGroup
import com.example.kyudo_app.infrastructure.persistence.entity.BelongingGroupEntity

object BelongingGroupMapper {
    fun toEntity(domain: BelongingGroup) =
        BelongingGroupEntity(id = domain.groupId, name = domain.name)

    fun toDomain(entity: BelongingGroupEntity) =
        BelongingGroup(groupId = entity.id, name = entity.name)
}