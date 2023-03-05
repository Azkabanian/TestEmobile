package com.iusupov.domain.usecase.flashsale

import com.iusupov.domain.repository.ProductRepository
import javax.inject.Inject

class FlashSaleUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke() = productRepository.getFlashSale()
}