package com.iusupov.data.repository

import com.iusupov.common.utils.wrapper.DataResult
import com.iusupov.data.mapper.FlashSaleDataDomainMapper
import com.iusupov.data.mapper.LatestDataDomainMapper
import com.iusupov.data.source.network.ProductNetworkDataSource
import com.iusupov.domain.model.FlashSaleResponseDomainModule
import com.iusupov.domain.model.LatestResponseDomainModule
import com.iusupov.domain.repository.ProductRepository
import javax.inject.Inject

class DefaultProductRepository @Inject constructor(
    private val productNetworkDataSource: ProductNetworkDataSource,
    private val flashSaleDataDomainMapper: FlashSaleDataDomainMapper,
    private val latestDataDomainMapper: LatestDataDomainMapper,
) : ProductRepository {

    override suspend fun getLatestProduct(): DataResult<LatestResponseDomainModule> {
        return when (val result = productNetworkDataSource.getLatestProduct()) {
            is DataResult.Success -> DataResult.Success(
                LatestResponseDomainModule(
                    latestDataDomainMapper.fromList(result.data.latestDataModule)
                )
            )
            is DataResult.Error -> DataResult.Error(result.exception)
        }
    }

    override suspend fun getFlashSale(): DataResult<FlashSaleResponseDomainModule> {
        return when (val result = productNetworkDataSource.getFlashSale()) {
            is DataResult.Success -> DataResult.Success(
                FlashSaleResponseDomainModule(
                    flashSaleDataDomainMapper.fromList(result.data.flash_sale)
                )
            )
            is DataResult.Error -> DataResult.Error(result.exception)
        }
    }
}