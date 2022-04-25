package com.pvthiendeveloper.coinprice.home.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pvthiendeveloper.coinprice.home.data.local.HomeLocal
import com.pvthiendeveloper.coinprice.home.data.local.entities.CryptoTable
import com.pvthiendeveloper.coinprice.home.data.meditor.CryptoMeditor
import com.pvthiendeveloper.coinprice.home.data.remote.HomeRemote
import com.pvthiendeveloper.coinprice.home.data.remote.model.mappers.ApiCryptoMapper
import com.pvthiendeveloper.coinprice.home.domain.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val local: HomeLocal,
    private val mediator: CryptoMeditor
) : HomeRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getListCrypto(pageSize: Int): Flow<PagingData<CryptoTable>> {
        return Pager(
            config = PagingConfig(pageSize, prefetchDistance = pageSize / 2),
            remoteMediator = mediator,
            pagingSourceFactory = { local.getListCrypto() }
        ).flow
    }
}