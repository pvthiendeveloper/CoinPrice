package com.pvthiendeveloper.coinprice.home.presentation.model

data class CryptoItemUiState(
    val id: String?,
    val name: String?,
    val symbol: String?,
    val image: String?,
    val currentPrice: String? = "",
    val priceChangePercentage24h: String? = "",
    val isPriceChangePercentage24hUp: Boolean
)