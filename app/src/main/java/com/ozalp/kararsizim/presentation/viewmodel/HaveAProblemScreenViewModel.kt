package com.ozalp.kararsizim.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozalp.kararsizim.R
import com.ozalp.kararsizim.domain.usecase.telegramMessageUseCase.SendMessageUseCase
import com.ozalp.kararsizim.presentation.state.HaveAProblemScreenState
import kotlinx.coroutines.launch

class HaveAProblemScreenViewModel(private val sendMessageUseCase: SendMessageUseCase) :
    ViewModel() {

    private var _screenState = mutableStateOf(HaveAProblemScreenState())
    val screenState get() = _screenState

    fun sendMessage(context: Context, message: String) {
        viewModelScope.launch {

            val response = sendMessageUseCase(message)

            if (response.isSuccessful) {
                _screenState.value = _screenState.value.copy(success = true, error = "")
            } else {
                _screenState.value = _screenState.value.copy(
                    success = false, error = context.getString(
                        R.string.unkown_error
                    )
                )
            }
        }
    }
}