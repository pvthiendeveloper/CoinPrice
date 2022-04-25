package com.pvthiendeveloper.coinprice.home.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.pvthiendeveloper.coinprice.home.data.local.entities.CryptoTable

@Dao
internal interface CryptoDao {

    @Query("SELECT * FROM crypto")
    fun getAll(): PagingSource<Int, CryptoTable>

    @Insert
    fun insertAll(cryptos: List<CryptoTable>)

    @Delete
    fun delete(crypto: CryptoTable)

    @Query("DELETE FROM crypto")
    suspend fun clear()
}