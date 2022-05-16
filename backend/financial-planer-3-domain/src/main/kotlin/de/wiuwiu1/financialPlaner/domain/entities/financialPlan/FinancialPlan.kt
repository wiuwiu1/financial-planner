package de.wiuwiu1.financialPlaner.domain.entities.financialPlan

import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.MoneyAmountConverter
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.NameConverter
import org.hibernate.annotations.IndexColumn
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
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
    val budget: MoneyAmount,
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = [CascadeType.ALL])
    var regularExpenses: MutableList<RegularExpense>,
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = [CascadeType.ALL])
    var categories: MutableList<Category>,
) {

    constructor() : this(0, Name("abc"), MoneyAmount(0), emptyList<RegularExpense>().toMutableList(), emptyList<Category>().toMutableList())

}

