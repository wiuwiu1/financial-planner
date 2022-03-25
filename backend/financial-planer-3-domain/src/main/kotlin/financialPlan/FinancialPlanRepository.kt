package financialPlan

import types.Id

interface FinancialPlanRepository {
    fun findAll(): List<FinancialPlan>
    fun findById(id: Id): FinancialPlan?
    fun create(financialPlan: FinancialPlan)
    fun update(financialPlan: FinancialPlan)
}