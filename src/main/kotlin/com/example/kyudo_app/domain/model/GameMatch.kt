package com.example.kyudo_app.domain.model


import java.util.Date

class GameMatch(
    val matchId: Int?,
    val matchDate: Date,
    val users: List<User> = emptyList(),
    val place: Place? = null
)
