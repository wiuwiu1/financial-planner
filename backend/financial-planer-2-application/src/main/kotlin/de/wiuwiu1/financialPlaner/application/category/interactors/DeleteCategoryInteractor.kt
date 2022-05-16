package de.wiuwiu1.financialPlaner.application.category.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class DeleteCategoryInteractor(
    val financialPlanRepository: FinancialPlanRepository
) {

    fun execute(planId: Long, categoryId: Long) {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")
        financialPlan.categories.removeIf { category -> category.id == categoryId }
        financialPlanRepository.update(financialPlan)
    }

}