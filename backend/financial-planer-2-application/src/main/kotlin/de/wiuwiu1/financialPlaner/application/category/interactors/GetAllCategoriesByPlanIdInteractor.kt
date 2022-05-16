package de.wiuwiu1.financialPlaner.application.category.interactors

import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component

@Component
class GetAllCategoriesByPlanIdInteractor(val financialPlanRepository: FinancialPlanRepository) {

    // TODO: remove boiler code
    fun execute(planId: Long): List<Category> {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")
        return financialPlan.categories
    }

}