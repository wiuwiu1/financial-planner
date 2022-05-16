package de.wiuwiu1.financialPlaner.domain.valueObjects.converter

import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class NameConverter: AttributeConverter<Name, String> {
    override fun convertToDatabaseColumn(name: Name?): String {
        return name!!.value
    }

    override fun convertToEntityAttribute(value: String?): Name {
        return Name(value!!)
    }

}