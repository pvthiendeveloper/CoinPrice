package com.pvthiendeveloper.coinprice.navigation.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.pvthiendeveloper.coinprice.navigation.deeplink.DeepLink

fun Fragment.navigate(deepLink: DeepLink) {
    val dl = NavDeepLinkRequest.Builder
        .fromUri(deepLink.getUri())
        .build()
    findNavController().navigate(dl)
}