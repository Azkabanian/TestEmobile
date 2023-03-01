package com.iusupov.network.mapper

import com.iusupov.common.mapper.Mapper
import com.iusupov.data.model.FlashSaleDataModule
import com.iusupov.network.model.FlashSaleNetworkModule
import javax.inject.Inject

class FlashSaleNetworkDataMapper @Inject constructor()
    : Mapper<FlashSaleNetworkModule, FlashSaleDataModule> {

    override fun from(i: FlashSaleNetworkModule): FlashSaleDataModule {
        return FlashSaleDataModule(
            category = i.category,
            discount = i.discount,
            image_url = i.image_url,
            name = i.name,
            price = i.price
        )
    }

    override fun to(o: FlashSaleDataModule): FlashSaleNetworkModule {
        return FlashSaleNetworkModule(
            category = o.category,
            discount = o.discount,
            image_url = o.image_url,
            name = o.name,
            price = o.price
        )
    }
}