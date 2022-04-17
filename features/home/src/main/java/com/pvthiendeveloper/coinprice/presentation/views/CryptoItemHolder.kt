package com.pvthiendeveloper.coinprice.presentation.views

import android.content.Context
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.bumptech.glide.Glide
import com.pvthiendeveloper.coinprice.home.R
import com.pvthiendeveloper.coinprice.home.databinding.HomeCryptoItemBinding
import com.pvthiendeveloper.coinprice.presentation.model.CryptoItemUiState
import com.pvthiendeveloper.coinprice.presentation.views.base.DataBindingModelHolder
import com.pvthiendeveloper.coinprice.ui.resource.CoinPriceColor

@EpoxyModelClass
internal abstract class CryptoItemModelHolder : DataBindingModelHolder<HomeCryptoItemBinding>() {

    @EpoxyAttribute
    var cryptoData: CryptoItemUiState? = null

    override fun onBind(context: Context, holder: HomeCryptoItemBinding) {
        val cryptoData = cryptoData ?: return

        holder.apply {
            tvName.text = cryptoData.name
            tvPrice.text = cryptoData.currentPrice

            tvPriceChangePer24h.text = cryptoData.priceChangePercentage24h
            if (cryptoData.isPriceChangePercentage24hIncrease) {
                tvPriceChangePer24h.setTextColor(
                    ContextCompat.getColor(
                        context,
                        CoinPriceColor.madang
                    )
                )
            } else {
                tvPriceChangePer24h.setTextColor(
                    ContextCompat.getColor(
                        context,
                        CoinPriceColor.eunry
                    )
                )
            }

            tvSymbol.text = cryptoData.symbol?.replace(
                cryptoData.symbol.first().toString(),
                cryptoData.symbol.first().toString().uppercase()
            )

            Glide.with(context)
                .load(cryptoData.image)
                .into(imgIcon)
        }
    }

    override fun onUnbind(holder: HomeCryptoItemBinding) {

    }

    override fun getDefaultLayout(): Int {
        return R.layout.home_crypto_item
    }
}