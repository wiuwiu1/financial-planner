package de.wiuwiu1.financialPlaner.application.budgetReport.interactors

import de.wiuwiu1.financialPlaner.domain.aggregates.IrregularExpenseBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import org.springframework.stereotype.Component

@Component
class CalculateIrregularExpenseBudgetReportInteractor {
    fun execute(financialPlan: FinancialPlan): IrregularExpenseBudgetReport {
        var spendBudget = 0
        financialPlan.categories.stream().forEach { category ->
            category.expenses.stream().forEach { expense -> spendBudget += expense.amount.cents }
        }
        var plannedBudget = 0
        financialPlan.regularExpenses.stream().forEach { expense ->  plannedBudget += expense.amount.cents}

        return IrregularExpenseBudgetReport(financialPlan.id, MoneyAmount(spendBudget), MoneyAmount(financialPlan.budget.cents - spendBudget - plannedBudget))
    }
}