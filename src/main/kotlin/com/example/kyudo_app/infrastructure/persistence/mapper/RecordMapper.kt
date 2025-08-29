package com.example.kyudo_app.infrastructure.persistence.mapper
import com.example.kyudo_app.domain.model.record
import com.example.kyudo_app.infrastructure.persistence.entity.RecordEntity

object RecordMapper {

    fun toEntity(domain: record): RecordEntity {
        val entity = RecordEntity()
        entity.id = domain.recordId
        entity.hitCount = domain.hitCount
        entity.totalShots = domain.totalShots
        entity.user = domain.user?.let { UserMapper.toEntity(it) }
        return entity
    }

    fun toDomain(entity: RecordEntity): record {
        return record(
            recordId = entity.id ?: 0L,
            hitCount = entity.hitCount ?: 0,
            totalShots = entity.totalShots ?: 0,
            user = entity.user?.let { UserMapper.toDomain(it) }
        )
    }
}
