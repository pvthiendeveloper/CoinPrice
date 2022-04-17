package com.pvthiendeveloper.coinprice.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.pvthiendeveloper.coinprice.domain.usecase.GetListCryptoUseCase
import com.pvthiendeveloper.coinprice.presentation.model.mappers.UiCryptoItemMapper
import com.pvthiendeveloper.coinprice.ui.resource.CoinPriceString
import com.pvthiendeveloper.coinprice.ui.resource.StringProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val stringProvider: StringProvider,
    private val getListCryptoUseCase: GetListCryptoUseCase,
    private val uiCryptoItemMapper: UiCryptoItemMapper
) : ViewModel() {

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
    }

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    fun fetchListCrypto() = getListCryptoUseCase(DEFAULT_PAGE_SIZE)
        .map { pagingData -> pagingData.map { uiCryptoItemMapper.mapToUiState(it) } }

    fun handleError(throwable: Throwable) {
        when (throwable) {
            is IOException, is ConnectException -> {
                _errorMessage.value =
                    stringProvider.getString(CoinPriceString.message_error_network)
            }
            else -> {
                _errorMessage.value =
                    stringProvider.getString(CoinPriceString.message_something_went_wrong)
            }
        }
    }
}