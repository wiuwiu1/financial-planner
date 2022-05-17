package de.wiuwiu1.financialPlaner.application.irregularExpense.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.irregularExpense.IrregularExpense
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component

@Component
class GetAllIrregularExpensesByPlanIdInteractor(val financialPlanRepository: FinancialPlanRepository) {

    // TODO: remove boiler code
    fun execute(planId: Long, categoryId: Long): List<IrregularExpense> {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")

        val optionalCategory = financialPlan.categories.stream().filter { category -> category.id == categoryId }.findAny()
        if (optionalCategory.isEmpty)
            throw IllegalArgumentException("Financial plan with the id $planId has no category with id $categoryId")
        val category = optionalCategory.get()

        return category.expenses
    }

}