package com.iusupov.cache.di

import android.app.Application
import androidx.room.Room
import com.iusupov.cache.database.TestEmobileDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val DATABASE_NAME = "testEmobile.db"

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

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

    @Singleton
    @Provides
    fun provideArticleDao(db: TestEmobileDataBase) = db.loginDao()
}