package com.iusupov.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iusupov.cache.database.login.LoginDao
import com.iusupov.cache.model.LoginTableCacheModel

@Database(
    entities = [LoginTableCacheModel::class],
    version = 1
)
abstract class TestEmobileDataBase : RoomDatabase() {
    abstract fun loginDao(): LoginDao
}