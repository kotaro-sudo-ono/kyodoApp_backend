package com.example.kyudo_app.presentation.controller.recordController.createRecord

import com.example.kyudo_app.application.useCase.recordUseCase.recordCreate.ArrowCreateParam
import com.example.kyudo_app.application.useCase.recordUseCase.recordCreate.RecordCreateCommand
import java.time.OffsetDateTime

data class RecordCreateRequest(
    val hitCount: Int,
    val totalShots: Int,
    val userId: String,
    val practiceDate: String? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowCreateRequestItem> = emptyList()
) {
    fun toCommand(): RecordCreateCommand {
        return RecordCreateCommand(
            hitCount = this.hitCount,
            totalShots = this.totalShots,
            userId = this.userId,
            practiceDate = this.practiceDate?.let { OffsetDateTime.parse(it).toLocalDateTime() },
            practiceTypeId = this.practiceTypeId,
            arrows = this.arrows.map { arrow ->
                ArrowCreateParam(
                    arrowNumber = arrow.arrowNumber,
                    positionX = arrow.positionX,
                    positionY = arrow.positionY,
                    isHit = arrow.isHit,
                    standNumber = arrow.standNumber
                )
            }
        )
    }
}

data class ArrowCreateRequestItem(
    val arrowNumber: Int,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean,
    val standNumber: Int = 1
) {
    init {
        require(standNumber >= 1) { "standNumber must be greater than or equal to 1" }
    }
}
