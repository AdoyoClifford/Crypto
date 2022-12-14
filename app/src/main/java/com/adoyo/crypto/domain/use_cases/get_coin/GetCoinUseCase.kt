package com.adoyo.crypto.domain.use_cases.get_coin

import com.adoyo.crypto.common.Resource
import com.adoyo.crypto.data.remote.mapper.toCoin
import com.adoyo.crypto.data.remote.mapper.toCoinDetail
import com.adoyo.crypto.domain.model.Coin
import com.adoyo.crypto.domain.model.CoinDetail
import com.adoyo.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}

