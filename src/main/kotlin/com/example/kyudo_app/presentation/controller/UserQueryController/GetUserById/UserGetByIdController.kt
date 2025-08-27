package com.example.kyudo_app.presentation.controller.UserQueryController.GetUserById

import com.example.kyudo_app.application.useCase.GetUserByIdUseCase.GetUserByIdParam
import com.example.kyudo_app.application.useCase.GetUserByIdUseCase.UserGetByIdUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = ["http://localhost:5173"])
class UserGetByIdController(
    private val userGetByIdUseCase: UserGetByIdUseCase
) {
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<GetUserByIdResponse> {
        val param = GetUserByIdParam(id)
        val dto = userGetByIdUseCase.getById(param)

        return if (dto != null) {
            ResponseEntity.ok(GetUserByIdResponse.from(dto))
        } else {
            ResponseEntity.notFound().build()
        }
    }
}