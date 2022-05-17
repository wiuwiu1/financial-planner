package de.wiuwiu1.financialPlaner.application.regularExpense.interactors

import de.wiuwiu1.financialPlaner.application.budgetReport.BudgetReportService
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.regularExpense.RegularExpense
import org.springframework.stereotype.Component

@Component
class AddRegularExpenseInteractor(
    private val financialPlanRepository: FinancialPlanRepository,
    private val budgetReportService: BudgetReportService
) {

    //todo smaller functions
    fun execute(planId: Long, regularExpense: RegularExpense): RegularExpense {
        val financialPlan = financialPlanRepository.findById(planId)
            ?: throw IllegalArgumentException("There is no financial plan with the id $planId")

        financialPlan.regularExpenses.stream().filter { expense -> expense.name == regularExpense.name }.findAny()
            .ifPresent {
                throw IllegalArgumentException(
                    "RegularExpense with name ${regularExpense.name.value} already exist with this name in the given financial plan"
                )
            }

        val budgetReport = budgetReportService.calculateFinancePlanBudgetReport(financialPlan)
        if (budgetReport.leftBudget.cents < regularExpense.amount.cents)
            throw  IllegalArgumentException("Cant plan regularExpense of ${regularExpense.amount.cents}. Given financial plan has only ${budgetReport.leftBudget.cents} cents left.")

        financialPlan.regularExpenses.add(regularExpense)
        financialPlanRepository.update(financialPlan)
        return (regularExpense)
    }

}