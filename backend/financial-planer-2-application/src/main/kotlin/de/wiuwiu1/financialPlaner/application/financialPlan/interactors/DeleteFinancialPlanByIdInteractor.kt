package de.wiuwiu1.financialPlaner.application.financialPlan.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Component

@Component
class DeleteFinancialPlanByIdInteractor(val financialPlanRepository: FinancialPlanRepository) {

    fun execute(id: Long) {
        financialPlanRepository.deleteById(id)
    }

}