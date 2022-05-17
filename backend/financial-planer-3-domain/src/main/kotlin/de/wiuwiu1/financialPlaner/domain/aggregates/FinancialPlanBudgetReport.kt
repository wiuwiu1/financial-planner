package de.wiuwiu1.financialPlaner.domain.aggregates

import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount

class FinancialPlanBudgetReport(
    override val planId: Long,
    override val spendBudget: MoneyAmount,
    override val leftBudget: MoneyAmount
) : BudgetReport