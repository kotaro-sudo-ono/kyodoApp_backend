package com.example.kyudo_app.presentation.controller.userQueryController.getAllUsers

import com.example.kyudo_app.application.useCase.UserGetAllUseCase.UserGetAllUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = ["http://localhost:5173"])
class UserGetAllController(
    private val userGetAllUseCase: UserGetAllUseCase
) {
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserGetAllResponse>> {
        val users = userGetAllUseCase.getAllUsers()
        return ResponseEntity.ok(users.map { UserGetAllResponse.from(it) })
    }
}
