package com.pvthiendeveloper.coinprice.home.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiCrypto(
    @SerialName("id")
    val id: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("symbol")
    val symbol: String? = ""
)