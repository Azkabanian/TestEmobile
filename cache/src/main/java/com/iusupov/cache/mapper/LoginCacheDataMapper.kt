package com.iusupov.cache.mapper

import com.iusupov.cache.model.LoginTableCacheModel
import com.iusupov.common.mapper.Mapper
import com.iusupov.data.model.LoginTableDataModel
import javax.inject.Inject

/**
 * Mapper class for convert [LoginTableCacheModel] to [LoginTableDataModel] and vice versa
 */
class LoginCacheDataMapper @Inject constructor() :
    Mapper<LoginTableCacheModel, LoginTableDataModel> {

    override fun from(i: LoginTableCacheModel): LoginTableDataModel {
        return LoginTableDataModel(
            id = i.Id,
            username = i.Username,
            password = i.Password
        )
    }

    override fun to(o: LoginTableDataModel): LoginTableCacheModel {
        return LoginTableCacheModel(
            Id = o.id,
            Username = o.username,
            Password = o.password
        )
    }
}
