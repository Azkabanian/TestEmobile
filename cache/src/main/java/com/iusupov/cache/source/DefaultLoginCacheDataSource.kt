package com.iusupov.cache.source

import com.iusupov.cache.database.login.LoginDao
import com.iusupov.cache.mapper.LoginCacheDataMapper
import com.iusupov.data.model.LoginTableDataModel
import com.iusupov.data.source.cache.LoginCacheDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultLoginCacheDataSource @Inject constructor(
    private val loginDao: LoginDao,
    private val loginCacheDataMapper: LoginCacheDataMapper
) : LoginCacheDataSource {

    override suspend fun insertData(loginTableDataModel: LoginTableDataModel) {
        loginCacheDataMapper.to(loginTableDataModel).let {
            loginDao.insertData(it)
        }
    }

    override fun getLoginDetails(username: String?): Flow<LoginTableDataModel> =
        loginDao.getLoginDetails(username).map {
            loginCacheDataMapper.from(it)
        }
}