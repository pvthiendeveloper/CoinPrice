package com.pvthiendeveloper.navigation.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.pvthiendeveloper.navigation.deeplink.DeepLink

fun Fragment.navigate(deepLink: DeepLink) {
    val dl = NavDeepLinkRequest.Builder
        .fromUri(deepLink.getUri())
        .build()
    findNavController().navigate(dl)
}