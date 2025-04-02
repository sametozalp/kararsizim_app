package com.ozalp.kararsizim.domain.repository

import com.ozalp.kararsizim.data.remote.dto.CategoryDto

interface CategoryRepository {

    suspend fun getCategories(): List<CategoryDto>
}