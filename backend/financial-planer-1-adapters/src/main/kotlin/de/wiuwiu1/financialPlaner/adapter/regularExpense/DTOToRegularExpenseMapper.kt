package de.wiuwiu1.financialPlaner.adapter.regularExpense

import de.wiuwiu1.financialPlaner.adapter.financialPlan.FinancialPlanDTO
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import org.springframework.stereotype.Component
import java.util.function.Function;

@Component
class DTOToRegularExpenseMapper : Function<RegularExpenseDTO, RegularExpense> {

    override fun apply(dto: RegularExpenseDTO): RegularExpense {
        return map(dto)
    }

    private fun map(dto: RegularExpenseDTO): RegularExpense {
        return RegularExpense(dto.id, Name(dto.name), MoneyAmount(dto.value))
    }
}