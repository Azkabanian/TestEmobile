package com.iusupov.data.source.network

import com.iusupov.common.utils.wrapper.DataResult
import com.iusupov.data.model.FlashSaleResponseDataModule
import com.iusupov.data.model.LatestResponseDataModule

interface ProductNetworkDataSource {
    suspend fun getLatestProduct(): DataResult<LatestResponseDataModule>
    suspend fun getFlashSale(): DataResult<FlashSaleResponseDataModule>
}