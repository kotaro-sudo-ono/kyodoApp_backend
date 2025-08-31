package com.example.kyudo_app.domain.model

class record(
    val recordId: Int?,
    val hitCount: Int,
    val totalShots: Int,
    val user: User? = null
)
