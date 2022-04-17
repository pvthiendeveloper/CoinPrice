package com.pvthiendeveloper.coinprice.data.remote.model.mappers

import com.pvthiendeveloper.coinprice.data.remote.model.ApiCrypto
import com.pvthiendeveloper.coinprice.domain.model.Crypto
import javax.inject.Inject

internal class ApiCryptoMapper @Inject constructor() : ApiMapper<ApiCrypto, Crypto> {

    override fun mapToDomain(apiEntity: ApiCrypto): Crypto {
        return Crypto(
            id = apiEntity.id,
            name = apiEntity.name,
            symbol = apiEntity.symbol,
            image = apiEntity.image,
            lastUpdated = apiEntity.lastUpdated,
            currentPrice = apiEntity.currentPrice,
            priceChangePercentage24h = apiEntity.priceChangePercentage24h
        )
    }
}