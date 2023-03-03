package com.iusupov.domain.usecase.latestproduct

import com.iusupov.domain.repository.ProductRepository
import javax.inject.Inject

class LatestProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke() = productRepository.getLatestProduct()
}