package de.wiuwiu1.financialPlaner.plugins.repositories.financialPlan

import de.wiuwiu1.financialPlaner.domain.financialPlan.FinancialPlan
import org.springframework.stereotype.Repository

@Repository
class FinancialPlanBridge(
        val repository: SpringDataFinancialPlanRepository
        ) : de.wiuwiu1.financialPlaner.domain.financialPlan.FinancialPlanRepository {
    override fun findAll(): List<FinancialPlan> {
        return repository.findAll()
    }

    override fun findById(id: Long): FinancialPlan? {
        return repository.getById(id)
    }

    override fun create(financialPlan: FinancialPlan): FinancialPlan {
        return repository.save(financialPlan)
    }

    override fun update(financialPlan: FinancialPlan): FinancialPlan {
        return repository.save(financialPlan)
    }
}