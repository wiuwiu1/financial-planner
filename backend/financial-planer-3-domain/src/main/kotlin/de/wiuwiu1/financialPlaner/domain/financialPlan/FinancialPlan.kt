package de.wiuwiu1.financialPlaner.domain.financialPlan

import de.wiuwiu1.financialPlaner.domain.types.Id
import de.wiuwiu1.financialPlaner.domain.types.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.types.Name

data class FinancialPlan(
    val id: Id,
    val name: Name,
    val budget: MoneyAmount
)

