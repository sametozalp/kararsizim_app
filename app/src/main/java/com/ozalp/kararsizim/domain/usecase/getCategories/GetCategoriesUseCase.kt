package com.ozalp.kararsizim.domain.usecase.getCategories

import com.ozalp.kararsizim.domain.model.Category
import com.ozalp.kararsizim.domain.repository.CategoryRepository
import com.ozalp.kararsizim.util.mapper.CategoryMapper

class GetCategoriesUseCase(private val repository: CategoryRepository) {

    suspend operator fun invoke(): List<Category> {
        return CategoryMapper.categoryDtoToCategory(repository.getCategories())
    }
}