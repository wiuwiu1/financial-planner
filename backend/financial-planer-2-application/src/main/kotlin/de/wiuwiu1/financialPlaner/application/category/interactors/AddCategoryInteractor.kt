package de.wiuwiu1.financialPlaner.application.category.interactors

import de.wiuwiu1.financialPlaner.application.budgetReport.BudgetReportService
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component

@Component
class AddCategoryInteractor(
    private val financialPlanRepository: FinancialPlanRepository,
    private val budgetReportService: BudgetReportService
) {

    //todo smaller functions
    fun execute(planId: Long, category: Category): Category {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")

        financialPlan.categories.stream().filter { c -> c.name == category.name }.findAny()
            .ifPresent {
                throw IllegalArgumentException(
                    "Category with name ${category.name} already exist with this name in the given financial plan"
                )
            }

        val budgetReport = budgetReportService.calculateFinancePlanBudgetReport(financialPlan)
        if (budgetReport.leftBudget.cents < category.budget.cents)
            throw  IllegalArgumentException("Cant plan category of ${category.budget.cents}. Given financial plan has only ${budgetReport.leftBudget.cents} cents left.")

        financialPlan.categories.add(category)
        financialPlanRepository.update(financialPlan)

        return category
    }

}