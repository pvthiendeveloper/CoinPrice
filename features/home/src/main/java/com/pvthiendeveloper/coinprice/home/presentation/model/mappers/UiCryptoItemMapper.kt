package com.pvthiendeveloper.coinprice.home.presentation.model.mappers

import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import com.pvthiendeveloper.coinprice.home.presentation.model.CryptoItemUiState
import com.pvthiendeveloper.coinprice.ui.extension.head
import com.pvthiendeveloper.coinprice.ui.resource.StringProvider
import com.pvthiendeveloper.coinprice.ui.resource.StringResource
import com.pvthiendeveloper.coinprice.utilities.format.PriceFormatter
import javax.inject.Inject

internal class UiCryptoItemMapper @Inject constructor(
    private val priceFormatter: PriceFormatter,
    private val stringProvider: StringProvider
) : UiStateMapper<Crypto, CryptoItemUiState> {

    override fun mapToUiState(input: Crypto): CryptoItemUiState {
        return CryptoItemUiState(
            id = input.id,
            name = input.name,
            image = input.image,
            symbol = input.symbol?.run { this.replace(head(), head().uppercase()) },
            currentPrice = stringProvider.getString(
                StringResource.price_usd,
                priceFormatter.doubleToUsd(input.currentPrice)
            ),
            priceChangePercentage24h = stringProvider.getString(
                StringResource.price_percentage,
                input.priceChangePercentage24h
            ),
            isPriceChangePercentage24hIncrease = input.priceChangePercentage24h ?: 0.0 > 0
        )
    }
}