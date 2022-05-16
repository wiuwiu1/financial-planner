package de.wiuwiu1.financialPlaner.adapter.regularExpense

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
data class RegularExpenseDTO(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("value")
    val value: Int
)
