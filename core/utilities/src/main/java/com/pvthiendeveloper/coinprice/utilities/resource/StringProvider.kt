package com.pvthiendeveloper.coinprice.utilities.resource

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringProvider @Inject constructor(@ApplicationContext private val context: Context) {

    fun getString(resId: Int): String {
        return context.getString(resId)
    }

    fun getString(resId: Int, vararg any: Any?): String {
        return context.getString(resId, *any)
    }
}