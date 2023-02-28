package com.iusupov.network.apiservice

import com.iusupov.network.model.FlashSaleNetworkModule
import com.iusupov.network.model.LatestNetworkModule
import com.iusupov.network.utils.NetworkConstants
import retrofit2.http.GET

interface ProductApiService {

    @GET(NetworkConstants.LATEST_ENDPOINT)
    suspend fun getLatestProduct(
    ): LatestNetworkModule

    @GET(NetworkConstants.FLASH_SALE_ENDPOINT)
    suspend fun getFlashSale(
    ): FlashSaleNetworkModule
}