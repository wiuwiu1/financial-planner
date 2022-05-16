package de.wiuwiu1.financialPlaner.domain.entities.financialPlan

interface FinancialPlanRepository {
    fun findAll(): List<FinancialPlan>
    fun findById(id: Long): FinancialPlan?
    fun create(financialPlan: FinancialPlan): FinancialPlan
    fun deleteById(id :Long)
    fun update(financialPlan: FinancialPlan)
}