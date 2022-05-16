package de.wiuwiu1.financialPlaner.adapter.category

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
class CategoryDTO(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("budget")
    val budget: Int
)