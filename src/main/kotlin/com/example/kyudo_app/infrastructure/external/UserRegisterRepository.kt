package com.example.kyudo_app.infrastructure.external

import com.example.kyudo_app.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRegisterRepository : JpaRepository<User?, Long?>

