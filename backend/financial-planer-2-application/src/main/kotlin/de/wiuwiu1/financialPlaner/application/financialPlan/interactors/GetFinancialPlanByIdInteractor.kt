package de.wiuwiu1.financialPlaner.application.financialPlan.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class GetFinancialPlanByIdInteractor(val financialPlanRepository: FinancialPlanRepository) {

    fun execute(id: Long): FinancialPlan {
        return financialPlanRepository.findById(id)
            ?: throw IllegalArgumentException("There is no financial plan with the id $id")
    }

}