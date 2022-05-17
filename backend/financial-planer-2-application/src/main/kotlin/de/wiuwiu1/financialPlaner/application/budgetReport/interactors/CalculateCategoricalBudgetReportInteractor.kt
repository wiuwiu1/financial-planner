package de.wiuwiu1.financialPlaner.application.budgetReport.interactors

import de.wiuwiu1.financialPlaner.domain.aggregates.CategoricalBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import org.springframework.stereotype.Component

@Component
class CalculateCategoricalBudgetReportInteractor {
    fun execute(planId: Long, category: Category): CategoricalBudgetReport {
        var spendBudget = 0
        category.expenses.stream().forEach { expense -> spendBudget += expense.amount.cents }
        return  CategoricalBudgetReport(planId, category.id, MoneyAmount(spendBudget), MoneyAmount(category.budget.cents - spendBudget))
    }
}