package com.ozalp.kararsizim.domain.usecase.telegramMessageUseCase

import com.ozalp.kararsizim.domain.repository.TelegramMessageRepository
import retrofit2.Response

class SendMessageUseCase(private val repository: TelegramMessageRepository) {

    suspend operator fun invoke(message: String): Response<Unit> {
        return repository.sendMessage(message)
    }
}