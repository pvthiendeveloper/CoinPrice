package com.pvthiendeveloper.ui

import android.app.Activity
import android.content.res.Resources.getSystem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.gone() {
    this.visibility = View.GONE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun Activity.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()

val Int.px: Int get() = (this * getSystem().displayMetrics.density).toInt()