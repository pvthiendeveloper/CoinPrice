package com.pvthiendeveloper.coinprice.presentation.model

internal data class CryptoItemUiState(
    val id: String?,
    val name: String?,
    val symbol: String?,
    val image: String?,
    val currentPrice: String? = "",
    val priceChangePercentage24h: String? = "",
    val isPriceChangePercentage24hIncrease: Boolean
)