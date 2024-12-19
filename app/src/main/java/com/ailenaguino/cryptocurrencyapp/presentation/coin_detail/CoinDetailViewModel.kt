package com.ailenaguino.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ailenaguino.cryptocurrencyapp.common.Constants
import com.ailenaguino.cryptocurrencyapp.common.Resource
import com.ailenaguino.cryptocurrencyapp.domain.usecases.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val useCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId -> getCoin(coinId) }
    }

    private fun getCoin(coinId: String) {
        useCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> _state.value =
                    CoinDetailState(coin = result.data)

                is Resource.Loading -> _state.value = CoinDetailState(isLoading = true)
                is Resource.Error -> _state.value =
                    CoinDetailState(error = result.message ?: "An unexpected error occurred")
            }
        }.launchIn(viewModelScope)
    }
}