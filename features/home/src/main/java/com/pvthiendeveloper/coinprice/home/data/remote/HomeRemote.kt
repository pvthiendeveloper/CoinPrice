package com.pvthiendeveloper.coinprice.home.data.remote

import com.pvthiendeveloper.coinprice.home.data.remote.api.HomeApi
import com.pvthiendeveloper.coinprice.home.data.remote.model.ApiCrypto
import javax.inject.Inject

internal interface HomeRemote {
    suspend fun getListCrypto(): List<ApiCrypto>
}

internal class HomeRemoteImpl @Inject constructor(
    private val api: HomeApi
): HomeRemote {

    override suspend fun getListCrypto(): List<ApiCrypto> {
        return api.getListCrypto()
    }
}