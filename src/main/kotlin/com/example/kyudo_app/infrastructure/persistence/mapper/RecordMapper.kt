package com.example.kyudo_app.infrastructure.persistence.mapper
import com.example.kyudo_app.domain.model.record
import com.example.kyudo_app.infrastructure.persistence.entity.RecordEntity

object RecordMapper {

    fun toEntity(domain: record): RecordEntity {
        return RecordEntity(
            id = domain.recordId,
            hitCount = domain.hitCount,
            totalShots = domain.totalShots,
            user = domain.user?.let { UserMapper.toEntity(it) }
        )
    }

    fun toDomain(entity: RecordEntity): record {
        return record(
            recordId = entity.id,
            hitCount = entity.hitCount ?: 0,
            totalShots = entity.totalShots ?: 0,
            user = entity.user?.let { UserMapper.toDomain(it) }
        )
    }
}
