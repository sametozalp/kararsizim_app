package com.ozalp.kararsizim.data.repository

import com.ozalp.kararsizim.data.remote.api.CategoryAPI
import com.ozalp.kararsizim.data.remote.dto.CategoryDto
import com.ozalp.kararsizim.domain.repository.CategoryRepository

class CategoryRepositoryImpl(private val api: CategoryAPI): CategoryRepository {
    override suspend fun getCategories(): List<CategoryDto> {
        return api.getCategories()
    }
}