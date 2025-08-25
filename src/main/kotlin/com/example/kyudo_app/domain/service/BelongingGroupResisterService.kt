package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.BelongingGroup
import com.example.kyudo_app.infrastructure.external.BelongingGroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BelongingGroupResisterService @Autowired constructor(val belongingGroupRepository: BelongingGroupRepository) {
    @Transactional
    fun registerBelongingGroup(belongingGroup: BelongingGroup): BelongingGroup {
        return belongingGroupRepository.save<BelongingGroup>(belongingGroup)
    }
}
