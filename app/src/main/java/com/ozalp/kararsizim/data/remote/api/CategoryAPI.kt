package com.ozalp.kararsizim.data.remote.api

import com.ozalp.kararsizim.data.remote.dto.CategoryDto
import com.ozalp.kararsizim.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryAPI {

    @GET("/rest/v1/categories")
    suspend fun getCategories(@Query("apikey") apiKey: String = Constant.API_KEY): List<CategoryDto>

}