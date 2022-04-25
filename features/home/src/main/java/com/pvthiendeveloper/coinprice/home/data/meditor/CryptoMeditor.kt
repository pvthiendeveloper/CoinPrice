package com.pvthiendeveloper.coinprice.home.data.meditor

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.pvthiendeveloper.coinprice.home.data.local.db.HomeDatabase
import com.pvthiendeveloper.coinprice.home.data.local.entities.CryptoTable
import com.pvthiendeveloper.coinprice.home.data.remote.HomeRemote
import com.pvthiendeveloper.coinprice.home.data.remote.model.mappers.ApiCryptoMapper
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
internal class CryptoMeditor @Inject constructor(
    private val db: HomeDatabase,
    private val remote: HomeRemote,
    private val mapper: ApiCryptoMapper
) : RemoteMediator<Int, CryptoTable>() {

    companion object {
        const val DEFAULT_OFFSET_INDEX = 0
    }

    private var offset = DEFAULT_OFFSET_INDEX

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CryptoTable>
    ): MediatorResult {

        val offset = when (val pageKeyData = getPageOffset(loadType)) {
            is MediatorResult.Success -> {
                return pageKeyData
            }
            else -> {
                pageKeyData as Int
            }
        }

        try {
            val cryptos = remote.getListCrypto(page = offset, perPage = state.config.pageSize)
            val isEndOfList = cryptos.isNullOrEmpty()

            this.offset += cryptos.size

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.cryptoDao().clear()
                }
                db.cryptoDao().insertAll(cryptos.map {
                    CryptoTable.fromDomain(mapper.mapToDomain(it))
                })
            }

            return MediatorResult.Success(endOfPaginationReached = isEndOfList)
        } catch (exception: Exception) {
            return MediatorResult.Error(exception)
        }
    }

    private fun getPageOffset(loadType: LoadType): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                this.offset = DEFAULT_OFFSET_INDEX
                this.offset
            }
            LoadType.APPEND -> {
                this.offset
            }
            LoadType.PREPEND -> {
                return MediatorResult.Success(endOfPaginationReached = true)
            }
        }
    }
}