package com.pvthiendeveloper.coinprice.home.data

import com.pvthiendeveloper.coinprice.home.data.remote.HomeRemote
import com.pvthiendeveloper.coinprice.home.data.remote.model.mappers.ApiCryptoMapper
import com.pvthiendeveloper.coinprice.home.domain.HomeRepository
import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val remote: HomeRemote,
    private val apiCryptoMapper: ApiCryptoMapper
) : HomeRepository {

    override suspend fun getListCrypto(): List<Crypto> {
       return remote.getListCrypto().map { apiCryptoMapper.mapToDomain(it) }
    }
}