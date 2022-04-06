package com.pvthiendeveloper.navigation.deeplink

import android.net.Uri

abstract class DeepLink {
    abstract fun getUri(): Uri
}

object DeepLinkDetail : DeepLink() {
    override fun getUri(): Uri {
        return DEEPLINK_DETAIL_URI
    }
}