package de.wiuwiu1.financialPlaner.application.financialPlan

import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.CreateFinancialPlanInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.DeleteFinancialPlanByIdInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetAllFinancialPlanInteractor
import de.wiuwiu1.financialPlaner.application.financialPlan.interactors.GetFinancialPlanByIdInteractor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.junit.jupiter.api.Test


internal class FinancialPlanServiceTest {
    private val createFinancialPlanInteractor: CreateFinancialPlanInteractor = mock()
    private val getFinancialPlanByIdInteractor: GetFinancialPlanByIdInteractor = mock()
    private val getAllFinancialPlanInteractor: GetAllFinancialPlanInteractor = mock()
    private val deleteFinancialPlanByIdInteractor: DeleteFinancialPlanByIdInteractor = mock()

    private val financialPlanService =  FinancialPlanService(createFinancialPlanInteractor, getFinancialPlanByIdInteractor, getAllFinancialPlanInteractor, deleteFinancialPlanByIdInteractor)

    private val validPlan = FinancialPlan()
    private val validPlanId = 1L

    @Test
    fun whenCreateFinancialPlan_thenCallInteractor(){
        financialPlanService.createFinancialPlan(validPlan)
        verify(createFinancialPlanInteractor, times(1)).execute(validPlan)
    }

    @Test
    fun whenGetFinancialPlanById_thenCallInteractor(){
        financialPlanService.getFinancialPlanById(validPlanId)
        verify(getFinancialPlanByIdInteractor, times(1)).execute(validPlanId)
    }

    @Test
    fun whenGetAllFinancialPlan_thenCallInteractor(){
        financialPlanService.getAllFinancialPlan()
        verify(getAllFinancialPlanInteractor, times(1)).execute()
    }

    @Test
    fun whenDeleteFinancialPlanById_thenCallInteractor(){
        financialPlanService.deleteFinancialPlanById(validPlanId)
        verify(deleteFinancialPlanByIdInteractor, times(1)).execute(validPlanId)
    }
}