package com.ozalp.kararsizim.domain.repository

import retrofit2.Response

interface TelegramMessageRepository {

    suspend fun sendMessage(message: String): Response<Unit>
}