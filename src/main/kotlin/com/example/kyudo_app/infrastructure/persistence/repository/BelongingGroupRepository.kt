package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.infrastructure.persistence.entity.BelongingGroupEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BelongingGroupRepository : JpaRepository<BelongingGroupEntity, String?>
