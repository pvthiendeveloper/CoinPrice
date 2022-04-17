package com.pvthiendeveloper.coinprice.data.local

import androidx.paging.PagingSource
import com.pvthiendeveloper.coinprice.data.local.db.HomeDatabase
import com.pvthiendeveloper.coinprice.data.local.entities.CryptoTable
import javax.inject.Inject

internal interface HomeLocal {

    fun getListCrypto(): PagingSource<Int, CryptoTable>
}

internal class HomeLocalImpl @Inject constructor(private val db: HomeDatabase) : HomeLocal {

    override fun getListCrypto(): PagingSource<Int, CryptoTable> {
        return db.cryptoDao().getAll()
    }
}