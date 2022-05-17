package de.wiuwiu1.financialPlaner.adapter.irregularExpense

import de.wiuwiu1.financialPlaner.domain.entities.irregularExpense.IrregularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class DTOToIrregularExpenseMapper: Function<IrregularExpenseDTO, IrregularExpense> {

    override fun apply(dto: IrregularExpenseDTO): IrregularExpense {
        return map(dto)
    }

    private fun map(dto: IrregularExpenseDTO): IrregularExpense {
        return IrregularExpense(dto.id, Name(dto.name), MoneyAmount(dto.value), dto.date)
    }
}