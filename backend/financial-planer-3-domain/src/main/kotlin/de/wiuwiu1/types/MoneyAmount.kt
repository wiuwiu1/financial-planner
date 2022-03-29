package de.wiuwiu1.types

data class MoneyAmount(val cents: Int) {
    init {
        require(cents >= 0) { "money amount cannot be negative" }
    }
}
