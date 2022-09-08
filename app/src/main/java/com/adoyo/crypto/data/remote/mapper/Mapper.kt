package com.adoyo.crypto.data.remote.mapper

import com.adoyo.crypto.data.remote.dto.CoinDetailDto
import com.adoyo.crypto.data.remote.dto.CoinDto
import com.adoyo.crypto.domain.model.Coin
import com.adoyo.crypto.domain.model.CoinDetail

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}