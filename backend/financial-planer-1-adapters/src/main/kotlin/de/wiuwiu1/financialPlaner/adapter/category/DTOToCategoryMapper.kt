package de.wiuwiu1.financialPlaner.adapter.category

import de.wiuwiu1.financialPlaner.adapter.regularExpense.RegularExpenseDTO
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class DTOToCategoryMapper : Function<CategoryDTO, Category> {

    override fun apply(dto: CategoryDTO): Category {
        return map(dto)
    }

    private fun map(dto: CategoryDTO): Category {
        return Category(dto.id, Name(dto.name), MoneyAmount(dto.budget))
    }
}