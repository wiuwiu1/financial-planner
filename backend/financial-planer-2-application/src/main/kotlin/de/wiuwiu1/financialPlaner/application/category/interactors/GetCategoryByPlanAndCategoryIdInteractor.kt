package de.wiuwiu1.financialPlaner.application.category.interactors

import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.springframework.stereotype.Component

@Component
class GetCategoryByPlanAndCategoryIdInteractor {

    fun execute(financialPlan: FinancialPlan, categoryId: Long): Category{
        val optionalCategory = financialPlan.categories.stream().filter { category -> category.id == categoryId }.findAny()
        if (optionalCategory.isEmpty)
            throw IllegalArgumentException("Financial plan with the id ${financialPlan.id} has no category with id $categoryId")
        return optionalCategory.get()
    }
}