package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.BelongingGroup
import com.example.kyudo_app.domain.repository.BelongingGroupRepositoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BelongingGroupRegisterDomainService(
    private val belongingGroupRepository: BelongingGroupRepositoryPort
) {

    @Transactional
    fun registerBelongingGroup(domainGroup: BelongingGroup): BelongingGroup =
        belongingGroupRepository.save(domainGroup)
}
