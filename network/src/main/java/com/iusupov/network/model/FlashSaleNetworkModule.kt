package com.iusupov.network.model

data class FlashSaleNetworkModule(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)