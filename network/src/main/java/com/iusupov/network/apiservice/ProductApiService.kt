package com.iusupov.network.apiservice

import com.iusupov.network.model.FlashSaleResponseNetworkModule
import com.iusupov.network.model.LatestResponseNetworkModule
import com.iusupov.network.utils.NetworkConstants
import retrofit2.http.GET

interface ProductApiService {

    @GET(NetworkConstants.LATEST_ENDPOINT)
    suspend fun getLatestProduct(
    ): LatestResponseNetworkModule

    @GET(NetworkConstants.FLASH_SALE_ENDPOINT)
    suspend fun getFlashSale(
    ): FlashSaleResponseNetworkModule
}