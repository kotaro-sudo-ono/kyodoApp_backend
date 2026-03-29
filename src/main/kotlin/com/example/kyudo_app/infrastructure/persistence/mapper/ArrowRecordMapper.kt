package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.ArrowRecord
import com.example.kyudo_app.infrastructure.persistence.entity.ArrowRecordEntity
import com.example.kyudo_app.infrastructure.persistence.entity.RecordEntity
import com.example.kyudo_app.infrastructure.ulid.UlidGenerator

object ArrowRecordMapper {

    fun toEntity(domain: ArrowRecord, record: RecordEntity): ArrowRecordEntity {
        return ArrowRecordEntity(
            arrowId = domain.arrowId ?: UlidGenerator.generateStatic(),
            arrowNo = domain.arrowNumber,
            hit = domain.isHit,
            positionX = domain.positionX,
            positionY = domain.positionY,
            standNumber = domain.standNumber,
            record = record
        )
    }

    fun toDomain(entity: ArrowRecordEntity): ArrowRecord {
        return ArrowRecord(
            arrowId = entity.arrowId,
            arrowNumber = entity.arrowNo ?: 0,
            positionX = entity.positionX,
            positionY = entity.positionY,
            isHit = entity.hit ?: false,
            standNumber = entity.standNumber ?: 1
        )
    }
}
