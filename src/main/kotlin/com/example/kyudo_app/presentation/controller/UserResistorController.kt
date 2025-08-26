package com.example.kyudo_app.presentation.controller

import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.domain.service.UserRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = ["http://localhost:5173"])
class UserResistorController(private val userRegisterService: UserRegisterService) {
    @get:GetMapping("/user")
    val users: String
        get() = "ユーザー一覧"

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<User?> {
        val registeredUser = userRegisterService.registryUser(user)
        return ResponseEntity.ok<User?>(registeredUser)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User?> {
        val user = userRegisterService.getUserById(id)
        return ResponseEntity.ok<User?>(user)
    }
}

