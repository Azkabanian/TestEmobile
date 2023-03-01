package com.iusupov.network.source

import com.iusupov.common.exception.NetworkException
import com.iusupov.common.mapper.ExceptionMapper
import com.iusupov.common.utils.wrapper.DataResult
import com.iusupov.data.connectivity.ConnectivityChecker
import com.iusupov.data.model.FlashSaleResponseDataModule
import com.iusupov.data.model.LatestResponseDataModule
import com.iusupov.data.source.ProductNetworkDataSource
import com.iusupov.network.apiservice.ProductApiService
import com.iusupov.network.mapper.FlashSaleNetworkDataMapper
import com.iusupov.network.mapper.LatestNetworkDataMapper
import javax.inject.Inject

class DefaultProductNetworkDataSource @Inject constructor(
    private val connectivityChecker: ConnectivityChecker,
    private val productApiService: ProductApiService,
    private val flashSaleNetworkDataMapper: FlashSaleNetworkDataMapper,
    private val latestNetworkDataMapper: LatestNetworkDataMapper,
    private val exceptionMapper: ExceptionMapper
): ProductNetworkDataSource {

    override suspend fun getLatestProduct(): DataResult<LatestResponseDataModule> {
        if (!connectivityChecker.hasInternetAccess()) {
            return DataResult.Error(NetworkException.NetworkUnavailable)
        }
        return try {
            val product = productApiService.getLatestProduct()
            DataResult.Success(
                LatestResponseDataModule(
                    latestNetworkDataMapper.fromList(product.latest)
                )
            )
        } catch (exception: Exception) {
            DataResult.Error(exceptionMapper.mapError(exception))
        }
    }

    override suspend fun getFlashSale(): DataResult<FlashSaleResponseDataModule> {
        if (!connectivityChecker.hasInternetAccess()) {
            return DataResult.Error(NetworkException.NetworkUnavailable)
        }
        return try {
            val product = productApiService.getFlashSale()
            DataResult.Success(
                FlashSaleResponseDataModule(
                    flashSaleNetworkDataMapper.fromList(product.flash_sale)
                )
            )
        } catch (exception: Exception) {
            DataResult.Error(exceptionMapper.mapError(exception))
        }
    }
}