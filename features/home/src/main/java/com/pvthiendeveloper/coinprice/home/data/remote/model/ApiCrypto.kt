package com.pvthiendeveloper.coinprice.home.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiCrypto(
    @SerialName("id")
    val id: String? = "",
    @SerialName("image")
    val image: String? = "",
    @SerialName("last_updated")
    val lastUpdated: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("symbol")
    val symbol: String? = "",
    @SerialName("current_price")
    val currentPrice: Double? = 0.0,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = 0.0,
)