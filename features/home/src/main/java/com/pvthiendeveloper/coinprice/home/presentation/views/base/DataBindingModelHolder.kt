package com.pvthiendeveloper.coinprice.home.presentation.views.base

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.airbnb.epoxy.EpoxyModelWithHolder

internal abstract class DataBindingModelHolder<in T : ViewBinding>: EpoxyModelWithHolder<DataBindingHolder>() {

    abstract fun onBind(context: Context, holder: T)

    abstract fun onUnbind(holder: T)

    @Suppress("UNCHECKED_CAST")
    override fun bind(holder: DataBindingHolder) {
        onBind(holder.binding.root.context, holder.binding as T)
    }

    @Suppress("UNCHECKED_CAST")
    override fun unbind(holder: DataBindingHolder) {
        super.unbind(holder)
        onUnbind(holder.binding as T)
    }
}

