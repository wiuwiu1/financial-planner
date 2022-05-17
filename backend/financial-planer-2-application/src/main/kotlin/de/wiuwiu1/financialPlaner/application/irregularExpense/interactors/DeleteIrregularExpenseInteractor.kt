package de.wiuwiu1.financialPlaner.application.irregularExpense.interactors

import de.wiuwiu1.financialPlaner.application.category.interactors.GetCategoryByPlanAndCategoryIdInteractor
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class DeleteIrregularExpenseInteractor(
    val financialPlanRepository: FinancialPlanRepository,
    private val getCategoryByPlanAndCategoryIdInteractor: GetCategoryByPlanAndCategoryIdInteractor,
) {

    fun execute(planId: Long, categoryId: Long, expenseId: Long) {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")

        val category = getCategoryByPlanAndCategoryIdInteractor.execute(financialPlan, categoryId)

        category.expenses.removeIf { expense -> expense.id == expenseId }
        financialPlanRepository.update(financialPlan)
    }

}