package de.wiuwiu1.financialPlaner.application.irregularExpense

import de.wiuwiu1.financialPlaner.application.irregularExpense.interactors.AddIrregularExpenseInteractor
import de.wiuwiu1.financialPlaner.application.irregularExpense.interactors.DeleteIrregularExpenseInteractor
import de.wiuwiu1.financialPlaner.application.irregularExpense.interactors.GetAllIrregularExpensesByPlanIdInteractor
import de.wiuwiu1.financialPlaner.domain.entities.irregularExpense.IrregularExpense
import org.springframework.stereotype.Service

@Service
class IrregularExpenseService(
    val getAllIrregularExpensesByPlanIdInteractor: GetAllIrregularExpensesByPlanIdInteractor,
    val addIrregularExpenseInteractor: AddIrregularExpenseInteractor,
    val deleteIrregularExpenseInteractor: DeleteIrregularExpenseInteractor
) {

    fun getAllIrregularExpenseByFinancialPlanId(planId: Long, categoryId: Long): List<IrregularExpense> {
        return getAllIrregularExpensesByPlanIdInteractor.execute(planId, categoryId)
    }

    fun addIrregularExpense(planId: Long, categoryId: Long, irregularExpense: IrregularExpense): IrregularExpense {
        return addIrregularExpenseInteractor.execute(planId, categoryId, irregularExpense)
    }

    fun deleteIrregularExpense(planId: Long, categoryId: Long, expenseId: Long) {
        deleteIrregularExpenseInteractor.execute(planId, categoryId, expenseId)
    }
}