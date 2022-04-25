package com.pvthiendeveloper.coinprice.home.di

import com.pvthiendeveloper.coinprice.home.data.HomeRepositoryImpl
import com.pvthiendeveloper.coinprice.home.data.local.HomeLocal
import com.pvthiendeveloper.coinprice.home.data.local.HomeLocalImpl
import com.pvthiendeveloper.coinprice.home.data.remote.HomeRemote
import com.pvthiendeveloper.coinprice.home.data.remote.HomeRemoteImpl
import com.pvthiendeveloper.coinprice.home.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DataModule {
    @Binds
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun bindHomeRemote(impl: HomeRemoteImpl): HomeRemote

    @Binds
    abstract fun bindHomeLocal(impl: HomeLocalImpl): HomeLocal
}