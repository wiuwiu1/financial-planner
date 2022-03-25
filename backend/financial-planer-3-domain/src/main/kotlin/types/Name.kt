package types

data class Name(val value: String) {
    init {
        require(value.isNotBlank()) { "name cannot be blank" }
        require(value.length >= 3) { "name has to be at least 3 characters long" }
        require(value.length < 128) { "name has to be less than 128 characters long" }
    }
}
