package com.example.kyudo_app.presentation.controller.recordController.monthlySummary

import com.example.kyudo_app.application.useCase.recordUseCase.recordMonthlySummary.RecordMonthlySummaryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = ["http://localhost:5173"])
class RecordMonthlySummaryController(
    private val recordMonthlySummaryUseCase: RecordMonthlySummaryUseCase
) {

    @GetMapping("/user/{userId}/monthly-summary")
    fun getMonthlySummary(
        @PathVariable userId: String,
        @RequestParam months: List<String>
    ): ResponseEntity<List<RecordMonthlySummaryResponse>> {
        val dtos = recordMonthlySummaryUseCase.getMonthlySummary(userId, months)
        return ResponseEntity.ok(dtos.map { RecordMonthlySummaryResponse.from(it) })
    }
}
