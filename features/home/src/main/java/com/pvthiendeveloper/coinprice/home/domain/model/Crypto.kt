package com.pvthiendeveloper.coinprice.home.domain.model

/*
* Every Layer owns its model to separate dependence
*
* */
internal data class Crypto(
    val id: String? = "",
    val image: String? = "",
    val lastUpdated: String? = "",
    val name: String? = "",
    val symbol: String? = "",
    val currentPrice: Double? = 0.0,
    val priceChangePercentage24h: Double? = 0.0,
)