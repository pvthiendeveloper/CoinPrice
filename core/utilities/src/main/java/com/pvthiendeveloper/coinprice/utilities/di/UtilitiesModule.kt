package com.pvthiendeveloper.coinprice.utilities.di

import android.app.Application
import android.content.Context
import com.pvthiendeveloper.coinprice.utilities.resource.StringProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilitiesModule {

    @Provides
    @Singleton
    fun providesStringProvider(@ApplicationContext context: Context): StringProvider =
        StringProvider(context)
}