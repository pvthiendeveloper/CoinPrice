package com.pvthiendeveloper.coinprice.home.domain

import com.pvthiendeveloper.coinprice.home.domain.model.Crypto

/*
* The Repository is a contract between Domain Layer and Data Layer
*
* It lets you:
* - Swap data sources without affecting the rest of the app
* - Create the boundary between the Data Layer and Other Layers that need to operate on data
*
* */
internal interface HomeRepository {

    suspend fun getListCrypto(): List<Crypto>
}