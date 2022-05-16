package de.wiuwiu1.financialPlaner.adapter.financialPlanBudgetReport

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
class FinancialPlanBudgetReportDTO(
    @JsonProperty("planId")
    val planId: Long,
    @JsonProperty("spendBudget")
    val spendBudget: Int,
    @JsonProperty("leftBudget")
    val leftBudget: Int
)