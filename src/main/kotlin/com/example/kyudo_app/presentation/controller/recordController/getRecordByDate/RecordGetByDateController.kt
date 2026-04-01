package com.example.kyudo_app.presentation.controller.recordController.getRecordByDate

import com.example.kyudo_app.application.useCase.recordUseCase.recordGetByDate.RecordGetByDateUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = ["http://localhost:5173"])
class RecordGetByDateController(
    private val recordGetByDateUseCase: RecordGetByDateUseCase
) {

    @GetMapping("/date/{date}")
    fun getRecordsByDate(@PathVariable date: String): ResponseEntity<List<RecordGetByDateResponse>> {
        val localDate = LocalDate.parse(date)  // YYYY-MM-DD
        val dtos = recordGetByDateUseCase.getRecordsByDate(localDate)
        return ResponseEntity.ok(dtos.map { RecordGetByDateResponse.from(it) })
    }
}
