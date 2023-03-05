package com.iusupov.domain.usecase.account.get

import com.iusupov.domain.repository.AccountRepository
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {

    operator fun invoke(username: String) = accountRepository.getLoginDetails(username)
}