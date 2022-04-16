package com.pvthiendeveloper.coinprice.home.data.remote.api

import com.pvthiendeveloper.coinprice.home.data.remote.model.ApiCrypto
import retrofit2.http.GET

interface HomeApi {
    @GET("/api/v3/coins/markets?vs_currency=usd")
    suspend fun getListCrypto(): List<ApiCrypto>
}