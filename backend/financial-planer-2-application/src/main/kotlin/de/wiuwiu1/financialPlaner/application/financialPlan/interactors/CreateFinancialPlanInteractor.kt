package de.wiuwiu1.financialPlaner.application.financialPlan.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class CreateFinancialPlanInteractor(val financialPlanRepository: FinancialPlanRepository) {

    fun execute(plan: FinancialPlan): FinancialPlan {
        return financialPlanRepository.create(plan)
    }

}