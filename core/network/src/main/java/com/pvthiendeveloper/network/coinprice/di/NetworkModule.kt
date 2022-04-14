package com.pvthiendeveloper.network.coinprice.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.pvthiendeveloper.network.coinprice.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, converter: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converter)
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor)
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    fun provideKotlinSerialization(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
        return json.asConverterFactory(contentType)
    }

}