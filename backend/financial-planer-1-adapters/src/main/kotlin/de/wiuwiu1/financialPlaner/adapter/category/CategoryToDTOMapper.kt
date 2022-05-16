package de.wiuwiu1.financialPlaner.adapter.category

import de.wiuwiu1.financialPlaner.adapter.regularExpense.RegularExpenseDTO
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class CategoryToDTOMapper: Function<Category, CategoryDTO> {

    override fun apply(category: Category): CategoryDTO {
        return map(category)
    }

    private fun map(category: Category): CategoryDTO {
        return CategoryDTO(category.id, category.name.value, category.budget.cents)
    }

}