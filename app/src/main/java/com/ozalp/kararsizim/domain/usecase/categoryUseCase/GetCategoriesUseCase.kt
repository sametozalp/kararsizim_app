package com.ozalp.kararsizim.domain.usecase.categoryUseCase

import com.ozalp.kararsizim.domain.model.Category
import com.ozalp.kararsizim.domain.repository.CategoryRepository
import com.ozalp.kararsizim.util.Resource
import com.ozalp.kararsizim.util.mapper.CategoryMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCategoriesUseCase(private val repository: CategoryRepository) {

    suspend operator fun invoke(): Flow<Resource<List<Category>>> = flow {

        try {
            emit(Resource.Loading())

            val categoryList = CategoryMapper.categoryDtoToCategory(repository.getCategories())
            emit(Resource.Success(categoryList))

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error", arrayListOf()))
        }
    }
}