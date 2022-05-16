package de.wiuwiu1.financialPlaner.domain.valueObjects.converter

import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
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