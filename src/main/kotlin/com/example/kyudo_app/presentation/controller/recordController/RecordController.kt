package com.example.kyudo_app.presentation.controller.recordController

import com.example.kyudo_app.application.useCase.recordUseCase.RecordUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = ["http://localhost:5173"])
class RecordController(
    private val recordUseCase: RecordUseCase
) {
    @PostMapping("/save")
    fun saveRecord(@RequestBody request: RecordSaveRequest): ResponseEntity<RecordSaveResponse> {
        val param = request.toParam()
        val dto = recordUseCase.saveRecord(param)
        val hoge = dto
        return ResponseEntity.ok(RecordSaveResponse.from(hoge))
    }

    @GetMapping("/user/{userId}")
    fun getRecordsByUserId(@PathVariable userId: String): ResponseEntity<List<RecordGetResponse>> {
        val dtos = recordUseCase.getRecordsByUserId(userId)
        return ResponseEntity.ok(dtos.map { RecordGetResponse.from(it) })
    }

    @GetMapping("/date/{date}")
    fun getRecordsByDate(@PathVariable date: String): ResponseEntity<List<RecordGetResponse>> {
        val localDate = java.time.LocalDate.parse(date)  // YYYY-MM-DD
        val dtos = recordUseCase.getRecordsByDate(localDate)
        return ResponseEntity.ok(dtos.map { RecordGetResponse.from(it) })
    }

    @GetMapping("/user/{userId}/monthly-summary")
    fun getMonthlySummary(
        @PathVariable userId: String,
        @RequestParam months: List<String>
    ): ResponseEntity<List<MonthlySummaryResponse>> {
        val dto = recordUseCase.getMonthlySummary(userId, months)
        return ResponseEntity.ok(dto.map { MonthlySummaryResponse.from(it) })
    }
}
