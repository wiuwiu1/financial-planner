package de.wiuwiu1.financialPlaner.domain.financialPlan

import de.wiuwiu1.financialPlaner.domain.types.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.types.MoneyAmountConverter
import de.wiuwiu1.financialPlaner.domain.types.Name
import de.wiuwiu1.financialPlaner.domain.types.NameConverter
import javax.persistence.*



@Entity
@Table(name = "financial_plan")
data class FinancialPlan(
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

