package de.wiuwiu1.financialPlaner.application.regularExpense

import de.wiuwiu1.financialPlaner.application.regularExpense.interactors.AddRegularExpenseInteractor
import de.wiuwiu1.financialPlaner.application.regularExpense.interactors.DeleteRegularExpenseInteractor
import de.wiuwiu1.financialPlaner.application.regularExpense.interactors.GetAllRegularExpensesByPlanIdInteractor
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Service

@Service
class RegularExpenseService(
    private val getAllRegularExpensesByPlanIdInteractor: GetAllRegularExpensesByPlanIdInteractor,
    private val addRegularExpenseInteractor: AddRegularExpenseInteractor,
    private val deleteRegularExpenseInteractor: DeleteRegularExpenseInteractor
) {

    fun getAllRegularExpenseByFinancialPlanId(planId: Long): List<RegularExpense> {
        return getAllRegularExpensesByPlanIdInteractor.execute(planId)
    }

    fun addRegularExpense(planId: Long, regularExpense: RegularExpense): RegularExpense {
        return addRegularExpenseInteractor.execute(planId, regularExpense)
    }

    fun deleteRegularExpense(planId: Long, expenseId: Long) {
        deleteRegularExpenseInteractor.execute(planId, expenseId)
    }
}