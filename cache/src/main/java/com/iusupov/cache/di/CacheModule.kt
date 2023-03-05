package com.iusupov.cache.di

import android.app.Application
import androidx.room.Room
import com.iusupov.cache.database.TestEmobileDataBase
import com.iusupov.cache.source.DefaultLoginCacheDataSource
import com.iusupov.data.source.cache.LoginCacheDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val DATABASE_NAME = "testEmobile.db"

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun provideLoginCacheDataSource(
        datasource: DefaultLoginCacheDataSource
    ): LoginCacheDataSource

    companion object {

        @Singleton
        @Provides
        fun provideArticleDatabase(
            app: Application
        ): TestEmobileDataBase {
            return Room.databaseBuilder(
                app,
                TestEmobileDataBase::class.java,
                DATABASE_NAME
            )
                .build()
        }

        @Provides
        fun provideArticleDao(db: TestEmobileDataBase) = db.loginDao()
    }
}