package de.wiuwiu1.financialPlaner.application.budgetReport

import de.wiuwiu1.financialPlaner.application.budgetReport.interactors.CalculateFinancialPlanBudgetReportInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetFinancialPlanByIdInteractor
import de.wiuwiu1.financialPlaner.domain.aggregates.FinancialPlanBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.springframework.stereotype.Service

@Service
class BudgetReportService(
    private val calculateFinancialPlanBudgetReportInteractor: CalculateFinancialPlanBudgetReportInteractor,
    private val getFinancialPlanByIdInteractor: GetFinancialPlanByIdInteractor
) {

    fun calculateFinancePlanBudgetReport(planId: Long): FinancialPlanBudgetReport {
        return calculateFinancePlanBudgetReport(getFinancialPlanByIdInteractor.execute(planId))
    }

    fun calculateFinancePlanBudgetReport(financialPlan: FinancialPlan): FinancialPlanBudgetReport {
        return calculateFinancialPlanBudgetReportInteractor.execute(financialPlan)
    }

}