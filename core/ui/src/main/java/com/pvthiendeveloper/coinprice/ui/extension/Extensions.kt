package com.pvthiendeveloper.coinprice.ui.extension

import android.app.Activity
import android.content.res.Resources.getSystem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(context).load(imageUrl).into(this)
}

fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun Fragment.showSnackBar(msg: String) {
    Snackbar.make(view!!, msg, Snackbar.LENGTH_SHORT).show()
}

val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()

val Int.px: Int get() = (this * getSystem().displayMetrics.density).toInt()

fun String.tail() = this.substring(1)

fun String.head() = this.substring(0, 1)

fun TextView.setTextColorRes(resId: Int) {
    this.setTextColor(ContextCompat.getColor(context, resId))
}