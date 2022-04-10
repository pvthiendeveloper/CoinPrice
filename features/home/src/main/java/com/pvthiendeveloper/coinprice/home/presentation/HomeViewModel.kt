package com.pvthiendeveloper.coinprice.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvthiendeveloper.coinprice.home.domain.usecase.GetListCryptoUseCase
import com.pvthiendeveloper.coinprice.home.presentation.model.HomeUiState
import com.pvthiendeveloper.coinprice.home.presentation.model.mappers.UiCryptoItemMapper
import com.pvthiendeveloper.coinprice.utilities.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListCryptoUseCase: GetListCryptoUseCase,
    private val uiCryptoItemMapper: UiCryptoItemMapper
) : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState(isLoading = true))
    val homeUiState = _homeUiState.asStateFlow()

    fun fetchListCrypto() {
        viewModelScope.launch {
            when (val response = getListCryptoUseCase()) {
                is Result.Success -> {
                    _homeUiState.update { uiState ->
                        uiState.copy(
                            isLoading = false,
                            cryptos = response.data.map { uiCryptoItemMapper.mapToUiState(it) }
                        )
                    }
                }
                is Result.Error -> {
                    _homeUiState.update { uiState ->
                        uiState.copy(
                            isLoading = false,

                        )
                    }
                }
            }
        }
    }
}