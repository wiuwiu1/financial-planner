package de.wiuwiu1.financialPlan

import de.wiuwiu1.types.Id
import de.wiuwiu1.types.MoneyAmount
import de.wiuwiu1.types.Name

data class FinancialPlan(
    val id: Id,
    val name: Name,
    val budget: MoneyAmount
)

