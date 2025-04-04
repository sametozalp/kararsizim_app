package com.ozalp.kararsizim.data.repository

import com.ozalp.kararsizim.data.remote.api.TelegramMessageAPI
import com.ozalp.kararsizim.domain.repository.TelegramMessageRepository
import retrofit2.Response

class TelegramMessageRepositoryImpl(private val api: TelegramMessageAPI) :
    TelegramMessageRepository {

    override suspend fun sendMessage(message: String): Response<Unit> {
        return api.sendMessage(message)
    }
}