package com.example.kyudo_app.infrastructure.external

import com.example.kyudo_app.domain.model.BelongingGroup
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AssignBelongingGroupRepository : JpaRepository<BelongingGroup?, Long?> {
    override fun findById(groupId: Long?): Optional<BelongingGroup?>
}
