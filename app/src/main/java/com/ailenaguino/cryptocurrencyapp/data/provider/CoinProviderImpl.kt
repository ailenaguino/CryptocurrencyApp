package com.ailenaguino.cryptocurrencyapp.data.provider

import com.ailenaguino.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.ailenaguino.cryptocurrencyapp.data.remote.dto.toCoin
import com.ailenaguino.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.ailenaguino.cryptocurrencyapp.domain.models.Coin
import com.ailenaguino.cryptocurrencyapp.domain.models.CoinDetail
import com.ailenaguino.cryptocurrencyapp.domain.provider.CoinProvider
import javax.inject.Inject

class CoinProviderImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinProvider{
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()
    }
}