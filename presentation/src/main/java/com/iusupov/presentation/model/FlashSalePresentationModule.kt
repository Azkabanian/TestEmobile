package com.iusupov.presentation.model

data class FlashSalePresentationModule(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)