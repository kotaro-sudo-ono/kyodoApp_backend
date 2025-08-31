package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.infrastructure.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository


interface UserRegisterRepository : JpaRepository<UserEntity?, Int?>
