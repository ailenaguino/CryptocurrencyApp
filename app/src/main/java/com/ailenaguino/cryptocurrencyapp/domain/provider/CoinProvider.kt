package com.ailenaguino.cryptocurrencyapp.domain.provider

import com.ailenaguino.cryptocurrencyapp.domain.models.Coin
import com.ailenaguino.cryptocurrencyapp.domain.models.CoinDetail

interface CoinProvider {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinDetail(coinId: String): CoinDetail
}