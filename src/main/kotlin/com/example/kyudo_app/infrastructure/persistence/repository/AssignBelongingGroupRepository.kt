package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.infrastructure.persistence.entity.BelongingGroupEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AssignBelongingGroupRepository : JpaRepository<BelongingGroupEntity, String> {
    override fun findById(groupId: String): Optional<BelongingGroupEntity>
}
