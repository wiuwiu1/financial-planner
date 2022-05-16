package de.wiuwiu1.financialPlaner.application.category

import de.wiuwiu1.financialPlaner.application.category.interactors.AddCategoryInteractor
import de.wiuwiu1.financialPlaner.application.category.interactors.DeleteCategoryInteractor
import de.wiuwiu1.financialPlaner.application.category.interactors.GetAllCategoriesByPlanIdInteractor
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Service

@Service
class CategoryService(
    val getAllCategoriesByPlanIdInteractor: GetAllCategoriesByPlanIdInteractor,
    val addCategoryInteractor: AddCategoryInteractor,
    val deleteCategoryInteractor: DeleteCategoryInteractor
) {

    fun getAllCategoriesByFinancialPlanId(planId: Long): List<Category> {
        return getAllCategoriesByPlanIdInteractor.execute(planId)
    }

    fun addCategory(planId: Long, category: Category): Category {
        return addCategoryInteractor.execute(planId, category)
    }

    fun deleteCategory(planId: Long, categoryId: Long) {
        deleteCategoryInteractor.execute(planId, categoryId)
    }
}