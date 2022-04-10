package com.pvthiendeveloper.coinprice.home.presentation.model.mappers

import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import com.pvthiendeveloper.coinprice.home.presentation.model.CryptoItemUiState
import javax.inject.Inject

class UiCryptoItemMapper @Inject constructor() : UiStateMapper<Crypto, CryptoItemUiState> {

    override fun mapToUiState(input: Crypto): CryptoItemUiState {
        return CryptoItemUiState(
            id = input.id,
            name = input.name,
            symbol = input.symbol
        )
    }
}