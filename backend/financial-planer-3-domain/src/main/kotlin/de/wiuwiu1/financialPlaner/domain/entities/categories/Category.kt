package de.wiuwiu1.financialPlaner.domain.entities.categories

import de.wiuwiu1.financialPlaner.domain.entities.irregularExpense.IrregularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.MoneyAmountConverter
import de.wiuwiu1.financialPlaner.domain.valueObjects.converter.NameConverter
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import javax.persistence.*

@Entity
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Convert(converter = NameConverter::class)
    val name: Name,
    @Convert(converter = MoneyAmountConverter::class)
    val budget: MoneyAmount,
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = [CascadeType.ALL])
    val expenses: MutableList<IrregularExpense>
) {
    constructor() : this(0, Name("abc"), MoneyAmount(0), emptyList<IrregularExpense>().toMutableList())
}