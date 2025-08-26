package com.example.kyudo_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KyudoAppApplication

fun main(args: Array<String>) {
    runApplication<KyudoAppApplication>(*args)
}
