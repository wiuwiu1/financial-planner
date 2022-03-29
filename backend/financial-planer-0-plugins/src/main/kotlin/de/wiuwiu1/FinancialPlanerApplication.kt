package de.wiuwiu1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FinancialPlanerApplication

fun main(args: Array<String>) {
    runApplication<FinancialPlanerApplication>(*args)
}