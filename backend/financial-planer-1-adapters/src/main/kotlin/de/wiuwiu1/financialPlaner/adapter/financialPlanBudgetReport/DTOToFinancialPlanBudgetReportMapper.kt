package de.wiuwiu1.financialPlaner.adapter.financialPlanBudgetReport

import de.wiuwiu1.financialPlaner.adapter.financialPlan.FinancialPlanDTO
import de.wiuwiu1.financialPlaner.domain.aggregates.FinancialPlanBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class DTOToFinancialPlanBudgetReportMapper: Function<FinancialPlanBudgetReportDTO, FinancialPlanBudgetReport> {

    override fun apply(dto: FinancialPlanBudgetReportDTO): FinancialPlanBudgetReport {
        return map(dto)
    }

    private fun map(dto: FinancialPlanBudgetReportDTO): FinancialPlanBudgetReport {
        return  FinancialPlanBudgetReport(dto.planId, MoneyAmount(dto.spendBudget), MoneyAmount(dto.leftBudget))
    }

}