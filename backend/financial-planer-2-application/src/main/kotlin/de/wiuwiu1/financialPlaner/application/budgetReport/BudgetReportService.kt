package de.wiuwiu1.financialPlaner.application.budgetReport

import de.wiuwiu1.financialPlaner.application.budgetReport.interactors.CalculateCategoricalBudgetReportInteractor
import de.wiuwiu1.financialPlaner.application.budgetReport.interactors.CalculateFinancialPlanBudgetReportInteractor
import de.wiuwiu1.financialPlaner.application.budgetReport.interactors.CalculateIrregularExpenseBudgetReportInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetFinancialPlanByIdInteractor
import de.wiuwiu1.financialPlaner.domain.aggregates.CategoricalBudgetReport
import de.wiuwiu1.financialPlaner.domain.aggregates.FinancialPlanBudgetReport
import de.wiuwiu1.financialPlaner.domain.aggregates.IrregularExpenseBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.springframework.stereotype.Service

@Service
class BudgetReportService(
    private val calculateFinancialPlanBudgetReportInteractor: CalculateFinancialPlanBudgetReportInteractor,
    private val calculateCategoricalBudgetReportInteractor: CalculateCategoricalBudgetReportInteractor,
    private val calculateIrregularExpenseBudgetReportInteractor: CalculateIrregularExpenseBudgetReportInteractor,
    private val getFinancialPlanByIdInteractor: GetFinancialPlanByIdInteractor
) {

    fun calculateFinancePlanBudgetReport(planId: Long): FinancialPlanBudgetReport {
        return calculateFinancePlanBudgetReport(getFinancialPlanByIdInteractor.execute(planId))
    }

    fun calculateFinancePlanBudgetReport(financialPlan: FinancialPlan): FinancialPlanBudgetReport {
        return calculateFinancialPlanBudgetReportInteractor.execute(financialPlan)
    }

    fun calculateCategoricalBudgetReport(planId: Long, category: Category) : CategoricalBudgetReport {
        return calculateCategoricalBudgetReportInteractor.execute(planId, category)
    }

    fun calculateIrregularExpenseBudgetReport(financialPlan: FinancialPlan) : IrregularExpenseBudgetReport {
        return calculateIrregularExpenseBudgetReportInteractor.execute(financialPlan)
    }

}