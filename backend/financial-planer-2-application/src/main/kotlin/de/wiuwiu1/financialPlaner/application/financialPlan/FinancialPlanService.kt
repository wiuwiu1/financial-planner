package de.wiuwiu1.financialPlaner.application.financialPlan

import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.CreateFinancialPlanInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.DeleteFinancialPlanByIdInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetAllFinancialPlanInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetFinancialPlanByIdInteractor
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.springframework.stereotype.Service

@Service
class FinancialPlanService(
    private val createFinancialPlanInteractor: CreateFinancialPlanInteractor,
    private val getFinancialPlanByIdInteractor: GetFinancialPlanByIdInteractor,
    private val getAllFinancialPlanInteractor: GetAllFinancialPlanInteractor,
    private val deleteFinancialPlanByIdInteractor: DeleteFinancialPlanByIdInteractor
) {

    fun createFinancialPlan(plan: FinancialPlan): FinancialPlan {
        return createFinancialPlanInteractor.execute(plan)
    }

    fun getFinancialPlanById(id: Long): FinancialPlan {
        return getFinancialPlanByIdInteractor.execute(id)
    }

    fun getAllFinancialPlan(): List<FinancialPlan> {
        return getAllFinancialPlanInteractor.execute()
    }

    fun deleteFinancialPlanById(id: Long) {
        deleteFinancialPlanByIdInteractor.execute(id)
    }

}