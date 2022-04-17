package com.pvthiendeveloper.coinprice.di

import android.content.Context
import com.pvthiendeveloper.coinprice.data.local.db.HomeDatabase
import com.pvthiendeveloper.coinprice.data.remote.api.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object HomeModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): HomeApi {
        return retrofit.create(HomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HomeDatabase {
        return HomeDatabase.newInstance(context)
    }
}