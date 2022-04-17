package com.pvthiendeveloper.coinprice.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pvthiendeveloper.coinprice.domain.model.Crypto

@Entity(tableName = "crypto")
internal data class CryptoTable(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String = "",
    @ColumnInfo("image")
    val image: String? = "",
    @ColumnInfo("last_updated")
    val lastUpdated: String? = "",
    @ColumnInfo("name")
    val name: String? = "",
    @ColumnInfo("symbol")
    val symbol: String? = "",
    @ColumnInfo("current_price")
    val currentPrice: Double? = 0.0,
    @ColumnInfo("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = 0.0,
) {

    /*
    * The domain model is a center of layers, so we need to map the Data Model to Domain Model
    * to keep it isolated and just communicate through the Repository Contract
    *
    * Of course, the Data Layer depends on Domain Layer
    * */
    internal fun toDomain(): Crypto {
        return Crypto(
            id = this.id,
            image = this.image,
            lastUpdated = this.lastUpdated,
            name = this.name,
            symbol = this.symbol,
            currentPrice = this.currentPrice,
            priceChangePercentage24h = this.priceChangePercentage24h,
        )
    }

    companion object {
        fun fromDomain(crypto: Crypto): CryptoTable {
            return CryptoTable(
                id = crypto.id.orEmpty(),
                image = crypto.image,
                lastUpdated = crypto.lastUpdated,
                name = crypto.name,
                symbol = crypto.symbol,
                currentPrice = crypto.currentPrice,
                priceChangePercentage24h = crypto.priceChangePercentage24h,
            )
        }
    }
}

