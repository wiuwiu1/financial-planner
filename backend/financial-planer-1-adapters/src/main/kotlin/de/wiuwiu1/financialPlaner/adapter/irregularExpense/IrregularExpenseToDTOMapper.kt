package de.wiuwiu1.financialPlaner.adapter.irregularExpense

import de.wiuwiu1.financialPlaner.domain.entities.irregularExpense.IrregularExpense
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class IrregularExpenseToDTOMapper: Function<IrregularExpense, IrregularExpenseDTO> {

    override fun apply(expense: IrregularExpense): IrregularExpenseDTO {
        return map(expense)
    }

    private fun map(expense: IrregularExpense): IrregularExpenseDTO {
        return IrregularExpenseDTO(expense.id, expense.name.value, expense.amount.cents, expense.date)
    }

}