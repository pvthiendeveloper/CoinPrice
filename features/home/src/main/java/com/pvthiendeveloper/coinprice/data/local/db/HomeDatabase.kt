package com.pvthiendeveloper.coinprice.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pvthiendeveloper.coinprice.data.local.dao.CryptoDao
import com.pvthiendeveloper.coinprice.data.local.entities.CryptoTable

@Database(entities = [CryptoTable::class], version = 1)
internal abstract class HomeDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao

    companion object {

        fun newInstance(context: Context): HomeDatabase {
            return Room.databaseBuilder(
                context, HomeDatabase::class.java, "home-database"
            ).build()
        }
    }
}