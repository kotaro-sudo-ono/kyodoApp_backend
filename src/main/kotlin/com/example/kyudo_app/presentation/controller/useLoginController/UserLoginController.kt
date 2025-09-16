package com.example.kyudo_app.presentation.controller.useLoginController

import com.example.kyudo_app.application.useCase.UserLoginUseCase.UserLoginUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = ["http://localhost:5173"])
class UserLoginController(
    private val userLoginUseCase: UserLoginUseCase
) {
    @PostMapping("/login")
    fun login(@RequestBody request: UserLoginRequest): ResponseEntity<UserLoginResponse> {
        val param = request.toParam()
        val dto = userLoginUseCase.login(param)  // UseCaseのloginでDTO受け取る
        val response = UserLoginResponse(dto.token)  // DTOからレスポンス生成
        return ResponseEntity.ok(response)
    }
}