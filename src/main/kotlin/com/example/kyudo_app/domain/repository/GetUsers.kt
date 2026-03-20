package com.example.kyudo_app.domain.repository

import com.example.kyudo_app.domain.model.User

interface GetUsers {
    fun findAll(): List<User>
}