package de.wiuwiu1.financialPlaner.domain.aggregates

import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount

class FinancialPlanBudgetReport(
    val planId: Long,
    val spendBudget: MoneyAmount,
    val leftBudget: MoneyAmount
)