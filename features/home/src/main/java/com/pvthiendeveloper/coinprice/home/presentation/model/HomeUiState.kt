package com.pvthiendeveloper.coinprice.home.presentation.model

data class HomeUiState(
    val isLoading: Boolean,
    val cryptos: List<CryptoItemUiState> = emptyList()
)

