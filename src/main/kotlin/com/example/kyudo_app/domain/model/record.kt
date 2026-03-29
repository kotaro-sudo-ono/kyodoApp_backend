package com.example.kyudo_app.domain.model

import java.time.LocalDateTime

class record(
    val recordId: String?,
    val hitCount: Int,
    val totalShots: Int,
    val user: User? = null,
    val practiceDate: LocalDateTime? = null,
    val practiceTypeId: Int? = null,
    val arrows: List<ArrowRecord> = emptyList(),
    val standNumber: Number? = null
)
