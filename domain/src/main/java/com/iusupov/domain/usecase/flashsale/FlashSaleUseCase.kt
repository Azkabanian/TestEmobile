package com.iusupov.domain.usecase.flashsale

import com.iusupov.domain.repository.ProductRepository

class FlashSaleUseCase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke() = productRepository.getFlashSale()
}