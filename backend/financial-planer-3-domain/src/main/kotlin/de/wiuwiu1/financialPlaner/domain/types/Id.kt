package de.wiuwiu1.financialPlaner.domain.types

data class Id(val value: Long) {
    init {
        require(value >= 0) { "id cannot be negative" }
    }
}