package com.example.kyudo_app.presentation.controller.recordController.createRecord

import com.example.kyudo_app.application.useCase.recordUseCase.recordCreate.RecordCreateUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = ["http://localhost:5173"])
class RecordCreateController(
    private val recordCreateUseCase: RecordCreateUseCase
) {

    @PostMapping("/save")
    fun createRecord(@RequestBody request: RecordCreateRequest): ResponseEntity<RecordCreateResponse> {
        val dto = recordCreateUseCase.createRecord(request.toCommand())
        return ResponseEntity.ok(RecordCreateResponse.from(dto))
    }
}
