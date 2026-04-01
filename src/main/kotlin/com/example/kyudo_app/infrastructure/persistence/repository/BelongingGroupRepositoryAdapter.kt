package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.domain.model.BelongingGroup
import com.example.kyudo_app.domain.repository.BelongingGroupRepositoryPort
import com.example.kyudo_app.infrastructure.persistence.mapper.BelongingGroupMapper
import org.springframework.stereotype.Repository

@Repository
class BelongingGroupRepositoryAdapter(
    private val belongingGroupRepository: BelongingGroupRepository
) : BelongingGroupRepositoryPort {

    override fun save(group: BelongingGroup): BelongingGroup =
        BelongingGroupMapper.toDomain(belongingGroupRepository.save(BelongingGroupMapper.toEntity(group)))
}
