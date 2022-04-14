package com.pvthiendeveloper.coinprice.home.presentation.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.pvthiendeveloper.coinprice.home.presentation.model.CryptoItemUiState
import com.pvthiendeveloper.coinprice.home.presentation.views.CryptoItemModelHolder_
import javax.inject.Inject

class HomeController @Inject constructor() : TypedEpoxyController<List<CryptoItemUiState>>() {

    override fun buildModels(data: List<CryptoItemUiState>?) {
        data?.forEach {
            CryptoItemModelHolder_()
                .id(it.id)
                .cryptoData(it)
                .addTo(this)
        }
    }
}