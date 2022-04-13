package com.pvthiendeveloper.coinprice.home.data.remote.model.mappers

import com.pvthiendeveloper.coinprice.home.data.remote.model.ApiCrypto
import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import javax.inject.Inject

class ApiCryptoMapper @Inject constructor() : ApiMapper<ApiCrypto, Crypto> {

    override fun mapToDomain(apiEntity: ApiCrypto): Crypto {
        return Crypto(
            id = apiEntity.id,
            name = apiEntity.name,
            symbol = apiEntity.symbol,
            ath = apiEntity.ath,
            athChangePercentage = apiEntity.athChangePercentage,
            athDate = apiEntity.athDate,
            atl = apiEntity.atl,
            atlChangePercentage = apiEntity.atlChangePercentage,
            atlDate = apiEntity.atlDate,
            circulatingSupply = apiEntity.circulatingSupply,
            currentPrice = apiEntity.currentPrice,
            fullyDilutedValuation = apiEntity.fullyDilutedValuation,
            high24h = apiEntity.high24h,
            image = apiEntity.image,
            lastUpdated = apiEntity.lastUpdated,
            low24h = apiEntity.low24h,
            marketCap = apiEntity.marketCap,
            marketCapChange24h = apiEntity.marketCapChange24h,
            marketCapChangePercentage24h = apiEntity.marketCapChangePercentage24h,
            marketCapRank = apiEntity.marketCapRank,
            maxSupply = apiEntity.maxSupply,
            priceChange24h = apiEntity.priceChange24h,
            priceChangePercentage24h = apiEntity.priceChangePercentage24h,
            totalSupply = apiEntity.totalSupply,
            totalVolume = apiEntity.totalVolume
        )
    }
}