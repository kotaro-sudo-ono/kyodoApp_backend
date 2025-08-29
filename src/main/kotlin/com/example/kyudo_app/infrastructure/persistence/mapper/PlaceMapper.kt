package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.Place
import com.example.kyudo_app.infrastructure.persistence.entity.PlaceEntity

object PlaceMapper {

    fun toEntity(domain: Place): PlaceEntity {
        val entity = PlaceEntity()
        entity.id = domain.placeId
        entity.name = domain.placeName
        entity.address = domain.placePoint
        // GameMatches は空リストにしておく、必要なら追加でセット
        entity.gameMatches = mutableListOf()
        return entity
    }

    fun toDomain(entity: PlaceEntity): Place {
        return Place(
            placeId = entity.id ?: 0,
            placeName = entity.name ?: "",
            placePoint = entity.address ?: ""
        )
    }
}
