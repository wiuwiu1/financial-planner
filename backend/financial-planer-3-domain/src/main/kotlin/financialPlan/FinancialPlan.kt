package financialPlan

import types.Id
import types.MoneyAmount
import types.Name

data class FinancialPlan(
    val id: Id,
    val name: Name,
    val budget: MoneyAmount
)

