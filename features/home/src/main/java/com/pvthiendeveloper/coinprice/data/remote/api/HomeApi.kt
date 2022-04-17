package com.pvthiendeveloper.coinprice.data.remote.api

import com.pvthiendeveloper.coinprice.data.remote.model.ApiCrypto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface HomeApi {

    @GET("/api/v3/coins/markets?vs_currency=usd")
    suspend fun getListCrypto(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): List<ApiCrypto>
}