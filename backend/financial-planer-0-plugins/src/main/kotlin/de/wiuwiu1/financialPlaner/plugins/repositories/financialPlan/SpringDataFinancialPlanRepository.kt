package de.wiuwiu1.financialPlaner.plugins.repositories.financialPlan

import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataFinancialPlanRepository: JpaRepository<FinancialPlan, Long>{
}