package com.pvthiendeveloper.coinprice.home.data.remote.model

import kotlinx.serialization.SerialName

data class ApiCrypto(
    @SerialName("ath")
    val ath: Int? = 0,
    @SerialName("ath_change_percentage")
    val athChangePercentage: Double? = 0.0,
    @SerialName("ath_date")
    val athDate: String? = "",
    @SerialName("atl")
    val atl: Double? = 0.0,
    @SerialName("atl_change_percentage")
    val atlChangePercentage: Double? = 0.0,
    @SerialName("atl_date")
    val atlDate: String? = "",
    @SerialName("circulating_supply")
    val circulatingSupply: Double? = 0.0,
    @SerialName("current_price")
    val currentPrice: Int? = 0,
    @SerialName("fully_diluted_valuation")
    val fullyDilutedValuation: Long? = 0,
    @SerialName("high_24h")
    val high24h: Int? = 0,
    @SerialName("id")
    val id: String? = "",
    @SerialName("image")
    val image: String? = "",
    @SerialName("last_updated")
    val lastUpdated: String? = "",
    @SerialName("low_24h")
    val low24h: Int? = 0,
    @SerialName("market_cap")
    val marketCap: Long? = 0,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Double? = 0.0,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double? = 0.0,
    @SerialName("market_cap_rank")
    val marketCapRank: Int? = 0,
    @SerialName("max_supply")
    val maxSupply: Double? = 0.0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("price_change_24h")
    val priceChange24h: Double? = 0.0,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = 0.0,
    @SerialName("symbol")
    val symbol: String? = "",
    @SerialName("total_supply")
    val totalSupply: Double? = 0.0,
    @SerialName("total_volume")
    val totalVolume: Long? = 0
)