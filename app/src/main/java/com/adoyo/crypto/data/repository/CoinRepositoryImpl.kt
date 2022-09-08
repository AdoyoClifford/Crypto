package com.adoyo.crypto.data.repository

import com.adoyo.crypto.data.remote.CoinPaprikaApi
import com.adoyo.crypto.data.remote.dto.CoinDetailDto
import com.adoyo.crypto.data.remote.dto.CoinDto
import com.adoyo.crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoin(coinId)
    }
}