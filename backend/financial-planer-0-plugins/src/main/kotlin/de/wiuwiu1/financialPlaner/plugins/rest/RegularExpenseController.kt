package de.wiuwiu1.financialPlaner.plugins.rest

import de.wiuwiu1.financialPlaner.adapter.regularExpense.DTOToRegularExpenseMapper
import de.wiuwiu1.financialPlaner.adapter.regularExpense.RegularExpenseDTO
import de.wiuwiu1.financialPlaner.adapter.regularExpense.RegularExpenseToDTOMapper
import de.wiuwiu1.financialPlaner.application.regularExpense.RegularExpenseService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/regularExpense")
class RegularExpenseController(
    private val service: RegularExpenseService,
    private val regularExpenseToDTOMapper: RegularExpenseToDTOMapper,
    private val dtoToRegularExpenseMapper: DTOToRegularExpenseMapper
) {

    @GetMapping(params = ["planId"], produces = ["application/json;charset=UTF-8"])
    fun getAllRegularExpensesByPlanId(@RequestParam planId: Long): List<RegularExpenseDTO> {
        return service.getAllRegularExpenseByFinancialPlanId(planId).stream()
            .map { expense -> regularExpenseToDTOMapper.apply(expense) }
            .collect(Collectors.toList())
    }

    @PostMapping(
        params = ["planId"],
        consumes = ["application/json;charset=UTF-8"],
        produces = ["application/json;charset=UTF-8"]
    )
    fun addRegularExpense(
        @RequestParam planId: Long,
        @RequestBody regularExpenseDTO: RegularExpenseDTO
    ): RegularExpenseDTO {
        return regularExpenseToDTOMapper.apply(
            service.addRegularExpense(
                planId,
                dtoToRegularExpenseMapper.apply(regularExpenseDTO)
            )
        )
    }

    @DeleteMapping(params = ["planId", "expenseId"])
    fun deleteRegularExpense(@RequestParam planId: Long, @RequestParam expenseId: Long) {
        service.deleteRegularExpense(planId, expenseId)
    }

}