package com.pvthiendeveloper.coinprice.home.domain.model

data class Crypto(
    val ath: Int? = 0,
    val athChangePercentage: Double? = 0.0,
    val athDate: String? = "",
    val atl: Double? = 0.0,
    val atlChangePercentage: Double? = 0.0,
    val atlDate: String? = "",
    val circulatingSupply: Double? = 0.0,
    val currentPrice: Int? = 0,
    val fullyDilutedValuation: Long? = 0,
    val high24h: Int? = 0,
    val id: String? = "",
    val image: String? = "",
    val lastUpdated: String? = "",
    val low24h: Int? = 0,
    val marketCap: Long? = 0,
    val marketCapChange24h: Double? = 0.0,
    val marketCapChangePercentage24h: Double? = 0.0,
    val marketCapRank: Int? = 0,
    val maxSupply: Double? = 0.0,
    val name: String? = "",
    val priceChange24h: Double? = 0.0,
    val priceChangePercentage24h: Double? = 0.0,
    val symbol: String? = "",
    val totalSupply: Double? = 0.0,
    val totalVolume: Long? = 0
)