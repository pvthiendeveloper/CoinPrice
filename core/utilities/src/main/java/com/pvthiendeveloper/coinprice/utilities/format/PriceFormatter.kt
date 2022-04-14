package com.pvthiendeveloper.coinprice.utilities.format

import java.text.DecimalFormat
import javax.inject.Inject

class PriceFormatter @Inject constructor() {

    fun doubleToUsd(value: Double?): String {
        return try {
            val formatter = DecimalFormat("###,###,##0.00")
            formatter.format(value ?: 0.0)
        } catch (e: Exception) {
            ""
        }
    }
}