package com.pvthiendeveloper.coinprice.home.presentation.controller

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging3.PagingDataEpoxyController
import com.pvthiendeveloper.coinprice.home.presentation.model.CryptoItemUiState
import com.pvthiendeveloper.coinprice.home.presentation.views.CryptoItemModelHolder_
import com.pvthiendeveloper.coinprice.home.presentation.views.EmptyItemModelHolder_
import com.pvthiendeveloper.coinprice.home.presentation.views.LoadingItemModelHolder_
import kotlinx.coroutines.ObsoleteCoroutinesApi
import javax.inject.Inject

@OptIn(ObsoleteCoroutinesApi::class)
internal class HomeController @Inject constructor() :
    PagingDataEpoxyController<CryptoItemUiState>() {

    private var isShowLoading = false

    override fun buildItemModel(currentPosition: Int, item: CryptoItemUiState?): EpoxyModel<*> {
        if (item == null) {
            return EmptyItemModelHolder_()
                .id(System.currentTimeMillis())
        }
        return CryptoItemModelHolder_()
            .id(item.id)
            .cryptoData(item)
    }

    override fun addModels(models: List<EpoxyModel<*>>) {
        super.addModels(models)
        LoadingItemModelHolder_()
            .id(System.currentTimeMillis())
            .addIf(isShowLoading, this)
    }

    fun showLoading(isLoading: Boolean) {
        this.isShowLoading = isLoading
        requestModelBuild()
    }
}