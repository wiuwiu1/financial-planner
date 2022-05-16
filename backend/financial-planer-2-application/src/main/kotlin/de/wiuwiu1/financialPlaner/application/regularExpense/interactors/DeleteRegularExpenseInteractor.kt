package de.wiuwiu1.financialPlaner.application.regularExpense.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component

@Component
class DeleteRegularExpenseInteractor(
    val financialPlanRepository: FinancialPlanRepository
) {

    fun execute(planId: Long, expenseId: Long) {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")
        financialPlan.regularExpenses.removeIf { expense -> expense.id == expenseId }
        financialPlanRepository.update(financialPlan)
    }

}