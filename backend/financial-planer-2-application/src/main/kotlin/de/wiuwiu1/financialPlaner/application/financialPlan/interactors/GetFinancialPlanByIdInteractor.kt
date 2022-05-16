package de.wiuwiu1.financialPlaner.application.financialPlan.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class GetFinancialPlanByIdInteractor(val financialPlanRepository: FinancialPlanRepository) {

    fun execute(id: Long): FinancialPlan {
        val possiblePlan = financialPlanRepository.findById(id)
        return possiblePlan ?: throw java.lang.RuntimeException()
    }

}