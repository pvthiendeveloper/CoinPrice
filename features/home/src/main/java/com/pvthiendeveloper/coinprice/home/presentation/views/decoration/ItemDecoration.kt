package com.pvthiendeveloper.coinprice.home.presentation.views.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pvthiendeveloper.coinprice.px

internal class ItemDecoration: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.left = 16.px
        outRect.right = 16.px
        outRect.top = 8.px
        outRect.bottom = 8.px
    }
}