package com.ailenaguino.cryptocurrencyapp.presentation.coin_list

import com.ailenaguino.cryptocurrencyapp.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
