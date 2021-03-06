package de.wiuwiu1.financialPlaner.plugins.rest

import de.wiuwiu1.financialPlaner.adapter.financialPlan.DTOToFinancialPlanMapper
import de.wiuwiu1.financialPlaner.adapter.financialPlan.FinancialPlanDTO
import de.wiuwiu1.financialPlaner.adapter.financialPlan.FinancialPlanToDTOMapper
import de.wiuwiu1.financialPlaner.application.financialPlan.FinancialPlanService
import de.wiuwiu1.financialPlaner.domain.entities.financialPlan.FinancialPlan
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/financialPlan")
class FinancialPlanController(
    private val service: FinancialPlanService,
    private val financialPlanToDTOMapper: FinancialPlanToDTOMapper,
    private val dtoToFinancialPlanMapper: DTOToFinancialPlanMapper
) {

    @GetMapping(produces = ["application/json;charset=UTF-8"])
    fun getAllFinancialPlan(): List<FinancialPlanDTO> {
        return service.getAllFinancialPlan().stream().map { plan -> financialPlanToDTOMapper.apply(plan) }
            .collect(Collectors.toList())
    }

    // TODO: refactor to lambda / stream
    @PostMapping(consumes = ["application/json;charset=UTF-8"], produces = ["application/json;charset=UTF-8"])
    fun createFinancialPlan(@RequestBody financialPlan: FinancialPlanDTO): FinancialPlanDTO {
        return financialPlanToDTOMapper.apply(service.createFinancialPlan(dtoToFinancialPlanMapper.apply(financialPlan)))
    }

    @DeleteMapping(params = ["id"])
    fun deleteFinancialPlanById(@RequestParam id: Long) {
        service.deleteFinancialPlanById(id)
    }
}