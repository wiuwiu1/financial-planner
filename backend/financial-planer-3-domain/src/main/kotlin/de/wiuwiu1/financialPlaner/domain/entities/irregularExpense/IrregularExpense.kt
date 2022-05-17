package de.wiuwiu1.financialPlaner.domain.entities.irregularExpense

import de.wiuwiu1.financialPlaner.domain.entities.Expense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.MoneyAmountConverter
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.NameConverter
import java.util.Date
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class IrregularExpense(
    @Id
    val id: Long,
    @Convert(converter = NameConverter::class)
    override val name: Name,
    @Convert(converter = MoneyAmountConverter::class)
    override val amount: MoneyAmount,
    val date: Date
) : Expense {

    constructor() : this(0, Name("abc"), MoneyAmount(0), Date())

}