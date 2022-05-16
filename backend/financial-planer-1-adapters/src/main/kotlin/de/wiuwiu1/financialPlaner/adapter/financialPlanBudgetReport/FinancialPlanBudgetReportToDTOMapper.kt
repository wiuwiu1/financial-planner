package de.wiuwiu1.financialPlaner.adapter.financialPlanBudgetReport

import de.wiuwiu1.financialPlaner.adapter.financialPlan.FinancialPlanDTO
import de.wiuwiu1.financialPlaner.domain.aggregates.FinancialPlanBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class FinancialPlanBudgetReportToDTOMapper: Function<FinancialPlanBudgetReport, FinancialPlanBudgetReportDTO> {

    override fun apply(report: FinancialPlanBudgetReport): FinancialPlanBudgetReportDTO {
        return map(report)
    }

    private fun map(report: FinancialPlanBudgetReport): FinancialPlanBudgetReportDTO {
        return FinancialPlanBudgetReportDTO(report.planId, report.spendBudget.cents, report.leftBudget.cents)
    }

}