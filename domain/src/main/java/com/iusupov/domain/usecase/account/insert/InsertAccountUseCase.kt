package com.iusupov.domain.usecase.account.insert

import com.iusupov.domain.model.LoginTableDomainModel
import com.iusupov.domain.repository.AccountRepository
import javax.inject.Inject

class InsertAccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(loginTableDomainModel: LoginTableDomainModel)
    = accountRepository.insertData(loginTableDomainModel)
}