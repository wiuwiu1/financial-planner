package de.wiuwiu1.financialPlaner.application.irregularExpense.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class DeleteIrregularExpenseInteractor(
    val financialPlanRepository: FinancialPlanRepository
) {

    fun execute(planId: Long, categoryId: Long, expenseId: Long) {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")

        val optionalCategory = financialPlan.categories.stream().filter { category -> category.id == categoryId }.findAny()
        if (optionalCategory.isEmpty)
            throw IllegalArgumentException("Financial plan with the id $planId has no category with id $categoryId")
        val category = optionalCategory.get()

        category.expenses.removeIf { expense -> expense.id == expenseId }
        financialPlanRepository.update(financialPlan)
    }

}