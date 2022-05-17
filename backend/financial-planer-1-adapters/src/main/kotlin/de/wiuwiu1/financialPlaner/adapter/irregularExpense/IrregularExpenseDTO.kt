package de.wiuwiu1.financialPlaner.adapter.irregularExpense

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
class IrregularExpenseDTO(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("value")
    val value: Int,
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val date: Date
)