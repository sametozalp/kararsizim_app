package com.ozalp.kararsizim.data.remote.api

import com.ozalp.kararsizim.data.remote.dto.ActivityDto
import com.ozalp.kararsizim.util.Constant
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ActivityAPI {
    @Headers("apikey: ${Constant.API_KEY}")
    @GET("rest/v1/activities")
    suspend fun getActivities(
        @Query("category_id") categoryId: String,
        @Query("select") select: String = "id,activity_title,activity_description,categories(category_name)",
    ): List<ActivityDto>
}