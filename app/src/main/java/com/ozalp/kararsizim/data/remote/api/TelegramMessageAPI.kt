package com.ozalp.kararsizim.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TelegramMessageAPI {

    //https://sametozalp.com?message=fdsafd
    @GET("/bot/telegram_messager.php")
    suspend fun sendMessage(@Query("message") message: String): Response<Unit>
}