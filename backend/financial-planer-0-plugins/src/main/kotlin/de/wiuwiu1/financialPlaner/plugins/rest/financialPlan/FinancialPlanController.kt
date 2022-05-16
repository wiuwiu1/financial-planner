package de.wiuwiu1.financialPlaner.plugins.rest.financialPlan

import de.wiuwiu1.financialPlaner.adapter.financialPlan.DTOToFinancialPlanMapper
import de.wiuwiu1.financialPlaner.adapter.financialPlan.FinancialPlanDTO
import de.wiuwiu1.financialPlaner.adapter.financialPlan.FinancialPlanToDTOMapper
import de.wiuwiu1.financialPlaner.application.financialPlan.FinancialPlanService
import de.wiuwiu1.financialPlaner.domain.financialPlan.FinancialPlan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/financialPlan")
class FinancialPlanController(
    val service: FinancialPlanService,
    val financialPlanToDTOMapper: FinancialPlanToDTOMapper,
    val dtoToFinancialPlanMapper: DTOToFinancialPlanMapper
) {

    @GetMapping(params = ["id"],  produces = ["application/json;charset=UTF-8"])
    fun getFinancialPlanById(@RequestParam id: Long): FinancialPlanDTO {
        return financialPlanToDTOMapper.apply(service.getFinancialPlanById(id))
    }

    // TODO: refactor to lambda / stream
    @PostMapping(consumes =  ["application/json;charset=UTF-8"],produces = ["application/json;charset=UTF-8"])
    fun createFinancialPlan(@RequestBody financialPlan: FinancialPlanDTO): FinancialPlanDTO {
        return financialPlanToDTOMapper.apply(service.createFinancialPlan(dtoToFinancialPlanMapper.apply(financialPlan)))
    }
}