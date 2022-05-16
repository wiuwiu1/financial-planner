package de.wiuwiu1.financialPlaner.domain.types.converter

import de.wiuwiu1.financialPlaner.domain.types.MoneyAmount
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class MoneyAmountConverter: AttributeConverter<MoneyAmount, Int> {
    override fun convertToDatabaseColumn(moneyAmount: MoneyAmount?): Int {
        return moneyAmount!!.cents
    }

    override fun convertToEntityAttribute(cents: Int?): MoneyAmount {
        return MoneyAmount(cents!!)
    }

}