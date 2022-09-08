package com.adoyo.crypto.prsesentation.coin_detail

import com.adoyo.crypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
