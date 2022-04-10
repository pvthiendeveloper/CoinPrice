package com.pvthiendeveloper.coinprice.home.data.remote.model.mappers

import com.pvthiendeveloper.coinprice.home.data.remote.model.ApiCrypto
import com.pvthiendeveloper.coinprice.home.data.remote.model.ApiMapper
import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import javax.inject.Inject

class ApiCryptoMapper @Inject constructor() : ApiMapper<ApiCrypto, Crypto> {

    override fun mapToDomain(apiEntity: ApiCrypto): Crypto {
        return Crypto(
            id = apiEntity.id,
            name = apiEntity.name,
            symbol = apiEntity.symbol
        )
    }
}