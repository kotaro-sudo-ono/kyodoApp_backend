package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.BelongingGroup
import com.example.kyudo_app.infrastructure.persistence.entity.BelongingGroupEntity
import com.example.kyudo_app.infrastructure.persistence.mapper.BelongingGroupMapper
import com.example.kyudo_app.infrastructure.persistence.repository.BelongingGroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BelongingGroupResisterDomainService @Autowired constructor(
    val belongingGroupRepository: BelongingGroupRepository
) {
    @Transactional
    fun registerBelongingGroup(domainGroup: BelongingGroup): BelongingGroup {
        // ドメインモデル → エンティティに変換
        val entity: BelongingGroupEntity = BelongingGroupMapper.toEntity(domainGroup)

        // JPAリポジトリで保存
        val savedEntity = belongingGroupRepository.save(entity)

        // エンティティ → ドメインモデルに変換して返す
        return BelongingGroupMapper.toDomain(savedEntity)
    }
}