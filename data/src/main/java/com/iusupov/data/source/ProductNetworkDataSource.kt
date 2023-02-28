package com.iusupov.data.source

import com.iusupov.common.utils.wrapper.DataResult
import com.iusupov.data.model.FlashSaleDataModule
import com.iusupov.data.model.LatestDataModule

interface ProductNetworkDataSource {
    suspend fun getLatestProduct(): DataResult<LatestDataModule>
    suspend fun getFlashSale(): DataResult<FlashSaleDataModule>
}