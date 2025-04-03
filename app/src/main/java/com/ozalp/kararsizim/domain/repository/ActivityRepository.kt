package com.ozalp.kararsizim.domain.repository

import com.ozalp.kararsizim.data.remote.dto.ActivityDto
import java.math.BigInteger

interface ActivityRepository {

    fun getActivities(categoryId: Int): List<ActivityDto>
}