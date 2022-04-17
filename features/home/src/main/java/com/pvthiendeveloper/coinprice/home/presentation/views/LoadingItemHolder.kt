package com.pvthiendeveloper.coinprice.home.presentation.views

import android.content.Context
import com.airbnb.epoxy.EpoxyModelClass
import com.pvthiendeveloper.coinprice.home.R
import com.pvthiendeveloper.coinprice.home.databinding.HomeLoadingItemBinding
import com.pvthiendeveloper.coinprice.home.presentation.views.base.DataBindingModelHolder

@EpoxyModelClass
internal abstract class LoadingItemModelHolder : DataBindingModelHolder<HomeLoadingItemBinding>() {

    override fun onBind(context: Context, holder: HomeLoadingItemBinding) {
    }

    override fun onUnbind(holder: HomeLoadingItemBinding) {
    }

    override fun getDefaultLayout(): Int {
        return R.layout.home_loading_item
    }
}