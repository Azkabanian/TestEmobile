package com.iusupov.data.repository

import com.iusupov.data.mapper.LoginDataDomainMapper
import com.iusupov.data.source.cache.LoginCacheDataSource
import com.iusupov.domain.model.LoginTableDomainModel
import com.iusupov.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultAccountRepository @Inject constructor(
    private val loginCacheDataSource: LoginCacheDataSource,
    private val loginDataDomainMapper: LoginDataDomainMapper
) : AccountRepository {

    override suspend fun insertData(loginTableDomainModel: LoginTableDomainModel) {
        loginDataDomainMapper.to(loginTableDomainModel).let {
            loginCacheDataSource.insertData(it)
        }
    }

    override fun getLoginDetails(username: String?): Flow<LoginTableDomainModel> {
        return loginCacheDataSource.getLoginDetails(username).map {
            loginDataDomainMapper.from(it)
        }
    }
}