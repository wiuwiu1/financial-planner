package de.wiuwiu1.financialPlaner.plugins.rest

import de.wiuwiu1.financialPlaner.adapter.irregularExpense.DTOToIrregularExpenseMapper
import de.wiuwiu1.financialPlaner.adapter.irregularExpense.IrregularExpenseDTO
import de.wiuwiu1.financialPlaner.adapter.irregularExpense.IrregularExpenseToDTOMapper
import de.wiuwiu1.financialPlaner.application.irregularExpense.IrregularExpenseService
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/irregularExpense")
class IrregularExpenseController(
    private val service: IrregularExpenseService,
    private val irregularExpenseToDTOMapper: IrregularExpenseToDTOMapper,
    private val dtoToIrregularExpenseMapper: DTOToIrregularExpenseMapper
) {

    @GetMapping(params = ["planId", "categoryId"], produces = ["application/json;charset=UTF-8"])
    fun getAllIrregularExpensesByPlanId(
        @RequestParam planId: Long,
        @RequestParam categoryId: Long
    ): List<IrregularExpenseDTO> {
        return service.getAllIrregularExpenseByFinancialPlanId(planId, categoryId).stream()
            .map { expense -> irregularExpenseToDTOMapper.apply(expense) }
            .collect(Collectors.toList())
    }

    @PostMapping(
        params = ["planId", "categoryId"],
        consumes = ["application/json;charset=UTF-8"],
        produces = ["application/json;charset=UTF-8"]
    )
    fun addIrregularExpense(
        @RequestParam planId: Long,
        @RequestParam categoryId: Long,
        @RequestBody irregularExpenseDTO: IrregularExpenseDTO
    ): IrregularExpenseDTO {
        return irregularExpenseToDTOMapper.apply(
            service.addIrregularExpense(
                planId,
                categoryId,
                dtoToIrregularExpenseMapper.apply(irregularExpenseDTO)
            )
        )
    }

    @DeleteMapping(params = ["planId", "categoryId", "expenseId"])
    fun deleteIrregularExpense(
        @RequestParam planId: Long,
        @RequestParam categoryId: Long,
        @RequestParam expenseId: Long
    ) {
        service.deleteIrregularExpense(planId, categoryId, expenseId)
    }
}