package de.wiuwiu1.financialPlaner.domain.entities.regularExpense

import de.wiuwiu1.financialPlaner.domain.entities.Expense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.MoneyAmountConverter
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.NameConverter
import javax.persistence.*

@Entity
class RegularExpense(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Convert(converter = NameConverter::class)
    override val name: Name,
    @Convert(converter = MoneyAmountConverter::class)
    override val value: MoneyAmount
) : Expense {

    constructor() : this(0, Name("abc"), MoneyAmount(0))

}