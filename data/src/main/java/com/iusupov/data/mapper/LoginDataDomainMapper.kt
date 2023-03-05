package com.iusupov.data.mapper

import com.iusupov.common.mapper.Mapper
import com.iusupov.data.model.LoginTableDataModel
import com.iusupov.domain.model.LoginTableDomainModel
import javax.inject.Inject

/**
 * Mapper class for convert [LoginTableDataModel] to [LoginTableDomainModel] and vice versa
 */
class LoginDataDomainMapper @Inject constructor() :
    Mapper<LoginTableDataModel, LoginTableDomainModel> {

    override fun from(i: LoginTableDataModel): LoginTableDomainModel {
        return LoginTableDomainModel(
            id = i.id,
            username = i.username,
            password = i.password
        )
    }

    override fun to(o: LoginTableDomainModel): LoginTableDataModel {
        return LoginTableDataModel(
            id = o.id,
            username = o.username,
            password = o.password
        )
    }
}
