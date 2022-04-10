package com.pvthiendeveloper.coinprice.home.data

import com.pvthiendeveloper.coinprice.home.data.remote.HomeRemote
import com.pvthiendeveloper.coinprice.home.data.remote.model.mappers.ApiCryptoMapper
import com.pvthiendeveloper.coinprice.home.domain.HomeRepository
import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import com.pvthiendeveloper.coinprice.utilities.coroutines.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remote: HomeRemote,
    private val apiCryptoMapper: ApiCryptoMapper
) : HomeRepository {

    override suspend fun getListCrypto(): List<Crypto> {
       return remote.getListCrypto().map { apiCryptoMapper.mapToDomain(it) }
    }
}