package com.example.kyudo_app.infrastructure.persistence.entity

import com.example.kyudo_app.infrastructure.ulid.UlidGenerator
import jakarta.persistence.PrePersist

class EntityListener {
    
    @PrePersist
    fun generateId(entity: Any) {
        when (entity) {
            is UserEntity -> if (entity.id == null) entity.id = UlidGenerator.generateStatic()
            is BelongingGroupEntity -> if (entity.id == null) entity.id = UlidGenerator.generateStatic()
            is GameMatchEntity -> if (entity.id == null) entity.id = UlidGenerator.generateStatic()
            is PlaceEntity -> if (entity.id == null) entity.id = UlidGenerator.generateStatic()
            is RecordEntity -> if (entity.id == null) entity.id = UlidGenerator.generateStatic()
            is TeamEntity -> if (entity.id == null) entity.id = UlidGenerator.generateStatic()
            is TeamMemberEntity -> if (entity.id == null) entity.id = UlidGenerator.generateStatic()
        }
    }
}
