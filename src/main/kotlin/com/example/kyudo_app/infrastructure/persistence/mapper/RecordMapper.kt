package com.example.kyudo_app.infrastructure.persistence.mapper
import com.example.kyudo_app.domain.model.record
import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.infrastructure.persistence.entity.RecordEntity

object RecordMapper {

    fun toEntity(domain: record): RecordEntity {
        return RecordEntity(
            id = domain.recordId,
            hitCount = domain.hitCount,
            totalShots = domain.totalShots,
            user = domain.user?.let { UserMapper.toEntity(it) },
            practiceDate = domain.practiceDate,
            practiceTypeId = domain.practiceTypeId
            // arrows は Entityのcascadeで処理するため不要
        )
    }

    fun toDomain(entity: RecordEntity): record {
        return record(
            recordId = entity.id,
            hitCount = entity.hitCount ?: 0,
            totalShots = entity.totalShots ?: 0,
            // 循環参照防止: UserMapper を経由せず User を直接生成し records は含めない
            user = entity.user?.let { u ->
                User(
                    userId = u.id,
                    name = u.name ?: "",
                    email = u.email ?: "",
                    userRole = u.userRole ?: 0,
                    password = u.password ?: "",
                    belongingGroup = u.belongingGroup?.let { BelongingGroupMapper.toDomain(it) },
                    gameMatches = emptyList(),
                    records = emptyList(),
                    teamMembers = emptyList()
                )
            },
            practiceDate = entity.practiceDate,
            practiceTypeId = entity.practiceTypeId,
            arrows = entity.arrows.map { ArrowRecordMapper.toDomain(it) }
        )
    }
}
