package com.pvthiendeveloper.coinprice.di

import com.pvthiendeveloper.coinprice.data.HomeRepositoryImpl
import com.pvthiendeveloper.coinprice.data.local.HomeLocal
import com.pvthiendeveloper.coinprice.data.local.HomeLocalImpl
import com.pvthiendeveloper.coinprice.data.remote.HomeRemote
import com.pvthiendeveloper.coinprice.data.remote.HomeRemoteImpl
import com.pvthiendeveloper.coinprice.domain.HomeRepository
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