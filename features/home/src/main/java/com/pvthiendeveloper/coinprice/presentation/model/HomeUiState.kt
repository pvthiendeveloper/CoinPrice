package com.pvthiendeveloper.coinprice.presentation.model

internal data class HomeUiState(
    val isLoading: Boolean,
    val message: String? = null,
    val cryptos: List<CryptoItemUiState> = emptyList()
)

