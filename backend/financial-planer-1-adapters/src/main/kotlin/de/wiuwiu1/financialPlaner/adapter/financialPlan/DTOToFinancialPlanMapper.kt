package de.wiuwiu1.financialPlaner.adapter.financialPlan

import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import org.springframework.stereotype.Component
import java.util.function.Function;

@Component
class DTOToFinancialPlanMapper: Function<FinancialPlanDTO, FinancialPlan> {

    override fun apply(dto: FinancialPlanDTO): FinancialPlan {
        return map(dto)
    }

    private fun map(dto: FinancialPlanDTO): FinancialPlan {
        return  FinancialPlan(dto.id, Name(dto.name), MoneyAmount(dto.budget), emptyList<RegularExpense>().toMutableList(), emptyList<Category>().toMutableList())
    }

}