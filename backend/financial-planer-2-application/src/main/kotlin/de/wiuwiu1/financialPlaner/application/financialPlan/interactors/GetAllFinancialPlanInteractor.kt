package de.wiuwiu1.financialPlaner.application.financialPlan.interactors

import de.wiuwiu1.financialPlaner.domain.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class GetAllFinancialPlanInteractor(val financialPlanRepository: FinancialPlanRepository) {
    fun execute(): List<FinancialPlan> {
        return financialPlanRepository.findAll()
    }
}