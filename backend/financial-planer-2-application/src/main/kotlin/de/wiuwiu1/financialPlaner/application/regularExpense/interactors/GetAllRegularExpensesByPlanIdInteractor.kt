package de.wiuwiu1.financialPlaner.application.regularExpense.interactors

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component

@Component
class GetAllRegularExpensesByPlanIdInteractor(val financialPlanRepository: FinancialPlanRepository) {

    // TODO: remove boiler code
    fun execute(planId: Long): List<RegularExpense> {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")
        return financialPlan.regularExpenses
    }

}