package com.example.kyudo_app.infrastructure.persistence.mapper

import com.example.kyudo_app.domain.model.Place
import com.example.kyudo_app.infrastructure.persistence.entity.PlaceEntity

object PlaceMapper {

    fun toEntity(domain: Place): PlaceEntity {
        return PlaceEntity(
            id = domain.placeId,
            name = domain.placeName,
            address = domain.placePoint,
            // GameMatches は空リストにしておく、必要なら追加でセット
            gameMatches = mutableListOf()
        )
    }

    fun toDomain(entity: PlaceEntity): Place {
        return Place(
            placeId = entity.id ?: 0,
            placeName = entity.name ?: "",
            placePoint = entity.address ?: ""
        )
    }
}
