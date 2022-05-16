package de.wiuwiu1.financialPlaner.domain.entities.categories

import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.MoneyAmountConverter
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.NameConverter
import javax.persistence.*

@Entity
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Convert(converter = NameConverter::class)
    val name: Name,
    @Convert(converter = MoneyAmountConverter::class)
    val budget: MoneyAmount
) {
    constructor() : this(0, Name("abc"), MoneyAmount(0))
}