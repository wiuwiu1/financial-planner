package de.wiuwiu1.financialPlaner.domain.aggregates

import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount

class CategoricalBudgetReport (
    override val planId: Long,
    val categoryId: Long,
    override val spendBudget: MoneyAmount,
    override val leftBudget: MoneyAmount
) : BudgetReport