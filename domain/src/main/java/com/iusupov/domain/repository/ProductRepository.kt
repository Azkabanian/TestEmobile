package com.iusupov.domain.repository

import com.iusupov.common.utils.wrapper.DataResult
import com.iusupov.domain.model.FlashSaleResponseDomainModule
import com.iusupov.domain.model.LatestResponseDomainModule

interface ProductRepository {
    suspend fun getLatestProduct(): DataResult<LatestResponseDomainModule>
    suspend fun getFlashSale(): DataResult<FlashSaleResponseDomainModule>
}