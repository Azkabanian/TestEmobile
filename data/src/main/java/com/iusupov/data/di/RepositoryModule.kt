package com.iusupov.data.di

import com.iusupov.data.repository.DefaultProductRepository
import com.iusupov.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAuthRepository(
        repository: DefaultProductRepository
    ): ProductRepository
}