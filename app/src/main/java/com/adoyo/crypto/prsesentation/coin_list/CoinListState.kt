package com.adoyo.crypto.prsesentation.coin_list

import com.adoyo.crypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
