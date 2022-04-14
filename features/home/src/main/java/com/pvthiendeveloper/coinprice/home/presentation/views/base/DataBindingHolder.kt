package com.pvthiendeveloper.coinprice.home.presentation.views.base

import android.view.View
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.EpoxyHolder

internal open class DataBindingHolder: EpoxyHolder() {

    lateinit var binding: ViewDataBinding

    @CallSuper
    override fun bindView(itemView: View) {
        binding = DataBindingUtil.bind(itemView)!!
    }
}