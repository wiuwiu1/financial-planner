package de.wiuwiu1.financialPlaner.plugins.rest

import de.wiuwiu1.financialPlaner.adapter.category.CategoryDTO
import de.wiuwiu1.financialPlaner.adapter.category.CategoryToDTOMapper
import de.wiuwiu1.financialPlaner.adapter.category.DTOToCategoryMapper
import de.wiuwiu1.financialPlaner.application.category.CategoryService
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/category")
class CategoryController(
    private val service: CategoryService,
    private val categoryToDTOMapper: CategoryToDTOMapper,
    private val dtoToCategoryMapper: DTOToCategoryMapper
) {
    @GetMapping(params = ["planId"], produces = ["application/json;charset=UTF-8"])
    fun getAllCategoriesByPlanId(@RequestParam planId: Long): List<CategoryDTO> {
        return service.getAllCategoriesByFinancialPlanId(planId).stream()
            .map { category -> categoryToDTOMapper.apply(category) }
            .collect(Collectors.toList())
    }

    @PostMapping(params = ["planId"], consumes = ["application/json;charset=UTF-8"])
    fun addCategory(
        @RequestParam planId: Long,
        @RequestBody categoryDTO: CategoryDTO
    ): CategoryDTO {
        return categoryToDTOMapper.apply(
            service.addCategory(
                planId,
                dtoToCategoryMapper.apply(categoryDTO)
            )
        )
    }

    @DeleteMapping(params = ["planId", "categoryId"])
    fun deleteCategory(@RequestParam planId: Long, @RequestParam categoryId: Long) {
        service.deleteCategory(planId, categoryId)
    }
}