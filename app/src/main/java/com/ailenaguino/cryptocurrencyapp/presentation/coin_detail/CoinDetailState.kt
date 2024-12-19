package com.ailenaguino.cryptocurrencyapp.presentation.coin_detail

import com.ailenaguino.cryptocurrencyapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
