package com.ailenaguino.cryptocurrencyapp.domain.usecases

import com.ailenaguino.cryptocurrencyapp.common.Resource
import com.ailenaguino.cryptocurrencyapp.domain.models.Coin
import com.ailenaguino.cryptocurrencyapp.domain.models.CoinDetail
import com.ailenaguino.cryptocurrencyapp.domain.provider.CoinProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val provider: CoinProvider) {
    operator fun invoke(id: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = provider.getCoinDetail(id)
            emit(Resource.Success(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server, check internet connection"))
        }
    }
}