package com.adoyo.crypto.domain.use_cases.get_coins

import com.adoyo.crypto.common.Resource
import com.adoyo.crypto.data.remote.mapper.toCoin
import com.adoyo.crypto.domain.model.Coin
import com.adoyo.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoins()
            emit(Resource.Success(coin.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An Unknown Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach the server"))
        }
    }
}