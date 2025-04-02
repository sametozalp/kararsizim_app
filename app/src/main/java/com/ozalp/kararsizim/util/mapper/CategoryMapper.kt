package com.ozalp.kararsizim.util.mapper

import com.ozalp.kararsizim.data.remote.dto.CategoryDto
import com.ozalp.kararsizim.domain.model.Category

object CategoryMapper {

    fun categoryDtoToCategory(dtoList: List<CategoryDto>): List<Category> {
        return dtoList.map { dto ->
            Category(
                id = dto.id,
                category_name = dto.category_name
            )
        }
    }

}