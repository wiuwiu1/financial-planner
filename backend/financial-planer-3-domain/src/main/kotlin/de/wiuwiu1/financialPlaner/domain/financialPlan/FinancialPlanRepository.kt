package de.wiuwiu1.financialPlaner.domain.financialPlan

interface FinancialPlanRepository {
    fun findAll(): List<FinancialPlan>
    fun findById(id: Long): FinancialPlan?
    fun create(financialPlan: FinancialPlan): FinancialPlan
    fun update(financialPlan: FinancialPlan): FinancialPlan
}