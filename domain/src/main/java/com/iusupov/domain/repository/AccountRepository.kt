package com.iusupov.domain.repository

import com.iusupov.domain.model.LoginTableDomainModel
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    suspend fun insertData(loginTableDomainModel: LoginTableDomainModel)
    fun getLoginDetails(username: String?): Flow<LoginTableDomainModel>
}