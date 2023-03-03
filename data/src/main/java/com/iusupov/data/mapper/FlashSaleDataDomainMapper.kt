package com.iusupov.data.mapper

import com.iusupov.common.mapper.Mapper
import com.iusupov.data.model.FlashSaleDataModule
import com.iusupov.domain.model.FlashSaleDomainModule
import javax.inject.Inject

class FlashSaleDataDomainMapper @Inject constructor()
    : Mapper<FlashSaleDataModule, FlashSaleDomainModule> {

    override fun from(i: FlashSaleDataModule): FlashSaleDomainModule {
        return FlashSaleDomainModule(
            category = i.category,
            discount = i.discount,
            image_url = i.image_url,
            name = i.name,
            price = i.price
        )
    }

    override fun to(o: FlashSaleDomainModule): FlashSaleDataModule {
        return FlashSaleDataModule(
            category = o.category,
            discount = o.discount,
            image_url = o.image_url,
            name = o.name,
            price = o.price
        )
    }
}