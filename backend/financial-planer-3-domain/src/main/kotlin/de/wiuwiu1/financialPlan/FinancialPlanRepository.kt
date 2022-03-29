package de.wiuwiu1.financialPlan

import de.wiuwiu1.types.Id

interface FinancialPlanRepository {
    fun findAll(): List<FinancialPlan>
    fun findById(id: Id): FinancialPlan?
    fun create(financialPlan: FinancialPlan)
    fun update(financialPlan: FinancialPlan)
}