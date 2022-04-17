package com.pvthiendeveloper.coinprice.presentation.views

import android.content.Context
import com.airbnb.epoxy.EpoxyModelClass
import com.pvthiendeveloper.coinprice.home.R
import com.pvthiendeveloper.coinprice.home.databinding.HomeEmptyItemBinding
import com.pvthiendeveloper.coinprice.presentation.views.base.DataBindingModelHolder

@EpoxyModelClass
internal abstract class EmptyItemModelHolder : DataBindingModelHolder<HomeEmptyItemBinding>() {

    override fun onBind(context: Context, holder: HomeEmptyItemBinding) {
    }

    override fun onUnbind(holder: HomeEmptyItemBinding) {
    }

    override fun getDefaultLayout(): Int {
        return R.layout.home_empty_item
    }
}