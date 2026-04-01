package com.example.kyudo_app.presentation.controller.recordController.getRecordByUser

import com.example.kyudo_app.application.useCase.recordUseCase.recordGetByUser.RecordGetByUserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = ["http://localhost:5173"])
class RecordGetByUserController(
    private val recordGetByUserUseCase: RecordGetByUserUseCase
) {

    @GetMapping("/user/{userId}")
    fun getRecordsByUserId(@PathVariable userId: String): ResponseEntity<List<RecordGetByUserResponse>> {
        val dtos = recordGetByUserUseCase.getRecordsByUserId(userId)
        return ResponseEntity.ok(dtos.map { RecordGetByUserResponse.from(it) })
    }
}
