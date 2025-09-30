package com.example.kyudo_app.presentation.controller.userRegisterController

import com.example.kyudo_app.application.useCase.UserRegisterUseCase.UserRegisterUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = ["http://localhost:5173"])
class UserRegisterController(
    private val userRegisterUseCase: UserRegisterUseCase
) {
    @PostMapping("/register")
    fun registerUser(@RequestBody request: UserRegisterRequest): ResponseEntity<UserRegisterResponse> {
        val dto = userRegisterUseCase.register(request.toParam())
        val response = UserRegisterResponse.from(dto)
        return ResponseEntity.ok(response)
    }
}