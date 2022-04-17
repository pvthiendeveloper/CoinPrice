package com.pvthiendeveloper.coinprice.data.remote

import com.pvthiendeveloper.coinprice.data.remote.api.HomeApi
import com.pvthiendeveloper.coinprice.data.remote.model.ApiCrypto
import javax.inject.Inject

internal interface HomeRemote {

    suspend fun getListCrypto(page: Int, perPage: Int): List<ApiCrypto>
}

internal class HomeRemoteImpl @Inject constructor(
    private val api: HomeApi
) : HomeRemote {

    override suspend fun getListCrypto(page: Int, perPage: Int): List<ApiCrypto> {
        return api.getListCrypto(page, perPage)
    }
}