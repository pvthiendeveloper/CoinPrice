package com.pvthiendeveloper.coinprice.home.presentation.model.mappers

import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import com.pvthiendeveloper.coinprice.home.presentation.model.CryptoItemUiState
import com.pvthiendeveloper.coinprice.utilities.CoinPriceString
import com.pvthiendeveloper.coinprice.utilities.format.PriceFormatter
import com.pvthiendeveloper.coinprice.utilities.resource.StringProvider
import javax.inject.Inject

class UiCryptoItemMapper @Inject constructor(
    private val priceFormatter: PriceFormatter,
    private val stringProvider: StringProvider
) : UiStateMapper<Crypto, CryptoItemUiState> {

    override fun mapToUiState(input: Crypto): CryptoItemUiState {
        return CryptoItemUiState(
            id = input.id,
            name = input.name,
            symbol = input.symbol,
            image = input.image,
            currentPrice = stringProvider.getString(
                CoinPriceString.price_usd,
                priceFormatter.doubleToUsd(input.currentPrice)
            ),
            priceChangePercentage24h = stringProvider.getString(
                CoinPriceString.price_percentage,
                input.priceChangePercentage24h
            ),
            isPriceChangePercentage24hIncrease = input.priceChangePercentage24h ?: 0.0 > 0
        )
    }
}