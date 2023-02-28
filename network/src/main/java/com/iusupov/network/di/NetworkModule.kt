package com.iusupov.network.di

import com.iusupov.network.apiservice.ProductApiService
import com.iusupov.network.utils.Extensions.moshi
import com.iusupov.network.utils.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_ENDPOINT)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): ProductApiService =
        retrofit.create(ProductApiService::class.java)
}
