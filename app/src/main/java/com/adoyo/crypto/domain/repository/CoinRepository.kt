package com.adoyo.crypto.domain.repository

import com.adoyo.crypto.data.remote.dto.CoinDetailDto
import com.adoyo.crypto.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}