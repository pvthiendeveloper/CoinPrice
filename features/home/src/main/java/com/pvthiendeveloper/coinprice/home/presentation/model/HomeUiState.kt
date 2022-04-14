package com.pvthiendeveloper.coinprice.home.presentation.model

data class HomeUiState(
    val isLoading: Boolean,
    val message: String? = null,
    val cryptos: List<CryptoItemUiState> = emptyList()
)

