package com.ozalp.kararsizim.data.remote.dto

data class ActivityDto(
    val activity_description: String,
    val activity_title: String,
    val categories: CategoriesInActivityDto,
    val id: Int
)