package com.iusupov.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Login")
data class LoginTableCacheModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null,

    @ColumnInfo(name = "username")
    var Username: String,

    @ColumnInfo(name = "password")
    var Password: String

)