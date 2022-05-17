package de.wiuwiu1.financialPlaner.application.irregularExpense.interactors

import com.nhaarman.mockitokotlin2.*
import de.wiuwiu1.financialPlaner.application.budgetReport.BudgetReportService
import de.wiuwiu1.financialPlaner.application.category.interactors.GetCategoryByPlanAndCategoryIdInteractor
import de.wiuwiu1.financialPlaner.domain.aggregates.CategoricalBudgetReport
import de.wiuwiu1.financialPlaner.domain.aggregates.IrregularExpenseBudgetReport
import de.wiuwiu1.financialPlaner.domain.entities.categories.Category
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlanRepository
import de.wiuwiu1.financialPlaner.domain.entities.irregularExpense.IrregularExpense
import de.wiuwiu1.financialPlaner.domain.valueObjects.MoneyAmount
import de.wiuwiu1.financialPlaner.domain.valueObjects.Name
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

internal class AddIrregularExpenseInteractorTest {
    private val financialPlanRepository: FinancialPlanRepository = mock()
    private val getCategoryByPlanAndCategoryIdInteractor: GetCategoryByPlanAndCategoryIdInteractor = mock()
    private val budgetReportService: BudgetReportService = mock()

    private val addIrregularExpenseInteractor = AddIrregularExpenseInteractor(financialPlanRepository,getCategoryByPlanAndCategoryIdInteractor, budgetReportService)

    private var e: Exception? = null

    private val validPlanId = 1L
    private val invalidPlanId = 2L
    private val validCategoryId = 1L
    private val invalidCategoryId = 2L
    private val validIrregularExpense = IrregularExpense(0, Name("abc"), MoneyAmount(10), Date())
    private val validFinancialPlan = FinancialPlan()
    private val validCategory = Category()
    private val validExpenseReport = IrregularExpenseBudgetReport(validPlanId, MoneyAmount(0), MoneyAmount(10))
    private val validCategoryReport = CategoricalBudgetReport(validPlanId, validCategoryId, MoneyAmount(0), MoneyAmount(10))

    init {
        whenever(financialPlanRepository.findById(validPlanId)).thenReturn(validFinancialPlan)
        whenever(financialPlanRepository.findById(invalidPlanId)).thenReturn(null)
        whenever(getCategoryByPlanAndCategoryIdInteractor.execute(validFinancialPlan, validCategoryId)).thenReturn(validCategory)
        whenever(getCategoryByPlanAndCategoryIdInteractor.execute(validFinancialPlan, invalidCategoryId)).thenThrow(IllegalArgumentException())
        whenever(budgetReportService.calculateIrregularExpenseBudgetReport(validFinancialPlan)).thenReturn(validExpenseReport)

        whenever(budgetReportService.calculateCategoricalBudgetReport(validFinancialPlan.id, validCategory)).thenReturn(validCategoryReport)
    }

    @BeforeEach
    fun setUp(){
        e = null
    }

    private fun do_execute(planId: Long, categoryId: Long, irregularExpense: IrregularExpense): IrregularExpense?{
        try {
            return addIrregularExpenseInteractor.execute(planId, categoryId, irregularExpense)
        } catch (e: Exception) {
            this.e = e
        }
        return null
    }

    @Test
    fun whenExecute_withInvalidPlanId_thenThrowException(){
        val result = do_execute(invalidPlanId, validCategoryId, validIrregularExpense)
        Assertions.assertThat(result).isNull()
        Assertions.assertThat(this.e).isExactlyInstanceOf(java.lang.IllegalArgumentException::class.java)
    }

    @Test
    fun whenExecute_withInvalidCategoryId_thenThrowException(){
        val result = do_execute(validPlanId, invalidCategoryId, validIrregularExpense)
        Assertions.assertThat(result).isNull()
        Assertions.assertThat(this.e).isExactlyInstanceOf(java.lang.IllegalArgumentException::class.java)
        verify(getCategoryByPlanAndCategoryIdInteractor, times(1)).execute(validFinancialPlan, invalidCategoryId)
    }

    @Test
    fun whenExecute_withAllValid_thenGetValidResult(){
        val result = do_execute(validPlanId, validCategoryId, validIrregularExpense)
        Assertions.assertThat(result).isEqualTo(validIrregularExpense)
        Assertions.assertThat(this.e).isNull()
        Assertions.assertThat(validCategory.expenses).contains(validIrregularExpense)
        verify(financialPlanRepository, times(1)).update(validFinancialPlan)
    }

}