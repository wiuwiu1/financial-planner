package de.wiuwiu1.financialPlaner.plugins.rest

import de.wiuwiu1.financialPlaner.adapter.financialPlanBudgetReport.FinancialPlanBudgetReportDTO
import de.wiuwiu1.financialPlaner.adapter.financialPlanBudgetReport.FinancialPlanBudgetReportToDTOMapper
import de.wiuwiu1.financialPlaner.application.budgetReport.BudgetReportService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/budgetReport")
class BudgetReportController(
    private val service: BudgetReportService,
    private val financialPlanBudgetReportToDTOMapper: FinancialPlanBudgetReportToDTOMapper
) {

    @GetMapping(value = ["/financialPlan"], params = ["planId"], produces = ["application/json;charset=UTF-8"])
    fun getFinancialPlanReport(@RequestParam planId: Long): FinancialPlanBudgetReportDTO{
        return financialPlanBudgetReportToDTOMapper.apply(service.calculateFinancePlanBudgetReport(planId))
    }
}