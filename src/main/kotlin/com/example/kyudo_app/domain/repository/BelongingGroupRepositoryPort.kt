package com.example.kyudo_app.domain.repository

import com.example.kyudo_app.domain.model.BelongingGroup

interface BelongingGroupRepositoryPort {
    fun save(group: BelongingGroup): BelongingGroup
}
