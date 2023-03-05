package com.iusupov.data.source.cache

import com.iusupov.data.model.LoginTableDataModel
import kotlinx.coroutines.flow.Flow

interface LoginCacheDataSource {

    suspend fun  insertData(loginTableDataModel: LoginTableDataModel)
    fun getLoginDetails(username: String?): Flow<LoginTableDataModel>
}