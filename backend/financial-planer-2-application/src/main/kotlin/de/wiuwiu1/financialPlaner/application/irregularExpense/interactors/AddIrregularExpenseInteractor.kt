package de.wiuwiu1.financialPlaner.application.irregularExpense.interactors

import de.wiuwiu1.financialPlaner.application.budgetReport.BudgetReportService
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.irregularExpense.IrregularExpense
import org.springframework.stereotype.Component

@Component
class AddIrregularExpenseInteractor(
    private val financialPlanRepository: FinancialPlanRepository,
    private val budgetReportService: BudgetReportService
) {

    //todo smaller functions
    fun execute(planId: Long, categoryId: Long, irregularExpense: IrregularExpense): IrregularExpense {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")

        val optionalCategory = financialPlan.categories.stream().filter { category -> category.id == categoryId }.findAny()
        if (optionalCategory.isEmpty)
            throw IllegalArgumentException("Financial plan with the id $planId has no category with id $categoryId")
        val category = optionalCategory.get()

        val expenseReport = budgetReportService.calculateIrregularExpenseBudgetReport(financialPlan)
        if(expenseReport.leftBudget.cents < irregularExpense.amount.cents)
            throw IllegalArgumentException("Financial plan with the id $planId has only ${expenseReport.leftBudget.cents} cents left")

        val categoryReport = budgetReportService.calculateCategoricalBudgetReport(financialPlan.id, category)
        if(categoryReport.leftBudget.cents < irregularExpense.amount.cents)
            throw IllegalArgumentException("Category with the id ${category.id} has only ${categoryReport.leftBudget.cents} cents left")

        category.expenses.add(irregularExpense)
        financialPlanRepository.update(financialPlan)
        return irregularExpense
    }

}