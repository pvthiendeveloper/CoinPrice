package com.pvthiendeveloper.coinprice.ui.di

import android.content.Context
import com.pvthiendeveloper.coinprice.ui.resource.StringProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UiModule {

    @Provides
    @Singleton
    fun providesStringProvider(@ApplicationContext context: Context) = StringProvider(context)
}