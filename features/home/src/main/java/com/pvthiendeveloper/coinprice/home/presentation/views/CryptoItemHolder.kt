package com.pvthiendeveloper.coinprice.home.presentation.views

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.pvthiendeveloper.coinprice.home.R
import com.pvthiendeveloper.coinprice.home.databinding.HomeCryptoItemBinding
import com.pvthiendeveloper.coinprice.home.presentation.model.CryptoItemUiState
import com.pvthiendeveloper.coinprice.home.presentation.views.base.DataBindingModelHolder
import com.pvthiendeveloper.coinprice.ui.extension.loadImage
import com.pvthiendeveloper.coinprice.ui.extension.setTextColorRes
import com.pvthiendeveloper.coinprice.ui.resource.ColorResource

@EpoxyModelClass
internal abstract class CryptoItemModelHolder : DataBindingModelHolder<HomeCryptoItemBinding>() {

    @EpoxyAttribute
    var cryptoData: CryptoItemUiState? = null

    override fun onBind(context: Context, holder: HomeCryptoItemBinding) {
        val cryptoData = cryptoData ?: return

        holder.apply {
            tvName.text = cryptoData.name
            tvPrice.text = cryptoData.currentPrice
            tvSymbol.text = cryptoData.symbol

            tvPriceChangePer24h.text = cryptoData.priceChangePercentage24h
            tvPriceChangePer24h.setTextColorRes(
                if (cryptoData.isPriceChangePercentage24hIncrease)
                    ColorResource.madang else ColorResource.eunry
            )

            imgIcon.loadImage(cryptoData.image ?: "")
        }
    }

    override fun onUnbind(holder: HomeCryptoItemBinding) {

    }

    override fun getDefaultLayout(): Int {
        return R.layout.home_crypto_item
    }
}