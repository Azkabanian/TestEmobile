package com.iusupov.network.di

import com.iusupov.data.source.network.ProductNetworkDataSource
import com.iusupov.network.apiservice.ProductApiService
import com.iusupov.network.source.DefaultProductNetworkDataSource
import com.iusupov.network.utils.Extensions.moshi
import com.iusupov.network.utils.NetworkConstants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun provideAccountNetworkDataSource(
        datasource: DefaultProductNetworkDataSource
    ): ProductNetworkDataSource

    companion object {

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
}
