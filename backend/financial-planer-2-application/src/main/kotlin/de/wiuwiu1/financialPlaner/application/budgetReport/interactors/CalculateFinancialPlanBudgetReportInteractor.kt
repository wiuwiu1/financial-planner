package de.wiuwiu1.financialPlaner.application.budgetReport.interactors

import de.wiuwiu1.financialPlaner.domain.aggregates.FinancialPlanBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import org.springframework.stereotype.Component

@Component
class CalculateFinancialPlanBudgetReportInteractor {

    fun execute(financialPlan: FinancialPlan): FinancialPlanBudgetReport {
        var plannedBudget = 0
        financialPlan.regularExpenses.forEach { expense -> plannedBudget += expense.amount.cents }
        financialPlan.categories.forEach { category -> plannedBudget += category.budget.cents }
        return FinancialPlanBudgetReport(financialPlan.id, MoneyAmount(plannedBudget), MoneyAmount(financialPlan.budget.cents - plannedBudget))
    }
}

