package de.wiuwiu1.financialPlaner.plugins.repositories.financialPlan

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import org.springframework.stereotype.Repository

@Repository
class FinancialPlanBridge(val repository: SpringDataFinancialPlanRepository) :
    FinancialPlanRepository {

    override fun findAll(): List<FinancialPlan> {
        return repository.findAll()
    }

    override fun findById(id: Long): FinancialPlan? {
        return repository.getById(id)
    }

    override fun create(financialPlan: FinancialPlan): FinancialPlan {
        return repository.save(financialPlan)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    override fun update(financialPlan: FinancialPlan) {
        repository.save(financialPlan)
    }

}