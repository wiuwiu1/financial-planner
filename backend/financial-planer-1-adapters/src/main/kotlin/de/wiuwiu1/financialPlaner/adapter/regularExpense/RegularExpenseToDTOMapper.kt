package de.wiuwiu1.financialPlaner.adapter.regularExpense

import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class RegularExpenseToDTOMapper: Function<RegularExpense, RegularExpenseDTO> {

    override fun apply(expense: RegularExpense): RegularExpenseDTO {
        return map(expense)
    }

    private fun map(expense: RegularExpense): RegularExpenseDTO {
        return RegularExpenseDTO(expense.id, expense.name.value, expense.value.cents)
    }

}