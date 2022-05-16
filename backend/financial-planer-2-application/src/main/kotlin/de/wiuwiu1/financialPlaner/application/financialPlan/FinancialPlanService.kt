package de.wiuwiu1.financialPlaner.application.financialPlan

import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.CreateFinancialPlanInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.DeleteFinancialPlanByIdInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetAllFinancialPlanInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetFinancialPlanByIdInteractor
import de.wiuwiu1.financialPlaner.domain.financialPlan.FinancialPlan
import org.springframework.stereotype.Service

@Service
class FinancialPlanService(
    val createFinancialPlanInteractor: CreateFinancialPlanInteractor,
    val getFinancialPlanByIdInteractor: GetFinancialPlanByIdInteractor,
    val getAllFinancialPlanInteractor: GetAllFinancialPlanInteractor,
    val deleteFinancialPlanByIdInteractor: DeleteFinancialPlanByIdInteractor
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