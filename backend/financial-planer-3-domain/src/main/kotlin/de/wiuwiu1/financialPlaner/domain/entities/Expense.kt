package de.wiuwiu1.financialPlaner.domain.entities

import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name

interface Expense {
    val name: Name
    val value: MoneyAmount
}