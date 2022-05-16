package de.wiuwiu1.financialPlaner.adapter.financialPlan

import de.wiuwiu1.financialPlaner.domain.financialPlan.FinancialPlan
import org.springframework.stereotype.Component
import java.util.function.Function;
@Component
class FinancialPlanToDTOMapper: Function<FinancialPlan, FinancialPlanDTO> {

    override fun apply(plan: FinancialPlan): FinancialPlanDTO {
        return map(plan)
    }

    private fun map(plan: FinancialPlan): FinancialPlanDTO {
        return FinancialPlanDTO(plan.id, plan.name.value, plan.budget.cents)
    }

}