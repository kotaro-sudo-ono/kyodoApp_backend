package com.example.kyudo_app.presentation.controller.recordController.updateRecord

import com.example.kyudo_app.application.useCase.recordUseCase.recordUpdate.ArrowUpdateParam
import com.example.kyudo_app.application.useCase.recordUseCase.recordUpdate.RecordUpdateCommand
import java.time.LocalDateTime

data class RecordUpdateRequest(
    val hitCount: Int,
    val totalShots: Int,
    val practiceDate: String? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowUpdateRequestItem> = emptyList(),
) {
    fun toCommand(recordId: String): RecordUpdateCommand {
        return RecordUpdateCommand(
            recordId = recordId,
            hitCount = this.hitCount,
            totalShots = this.totalShots,
            practiceDate = this.practiceDate?.let { LocalDateTime.parse(it) },
            practiceTypeId = this.practiceTypeId,
            arrows = this.arrows.map { arrow ->
                ArrowUpdateParam(
                    arrowNumber = arrow.arrowNumber,
                    standNumber = arrow.standNumber,
                    positionX = arrow.positionX,
                    positionY = arrow.positionY,
                    isHit = arrow.isHit
                )
            },
        )
    }
}

data class ArrowUpdateRequestItem(
    val arrowNumber: Int,
    val standNumber: Int = 1,
    val positionX: Double?,
    val positionY: Double?,
    val isHit: Boolean
) {
    init {
        require(standNumber >= 1) { "standNumber must be greater than or equal to 1" }
    }
}
