package com.ozalp.kararsizim.data.repository

import com.ozalp.kararsizim.data.remote.api.ActivityAPI
import com.ozalp.kararsizim.data.remote.dto.ActivityDto
import com.ozalp.kararsizim.domain.repository.ActivityRepository
import java.math.BigInteger

class ActivityRepositoryImpl(val api: ActivityAPI) : ActivityRepository {
    override suspend fun getActivities(categoryId: String): List<ActivityDto> {
        return api.getActivities("eq."+categoryId)
    }

}