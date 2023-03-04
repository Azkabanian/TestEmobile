package com.iusupov.presentation.mapper

import com.iusupov.common.mapper.Mapper
import com.iusupov.domain.model.FlashSaleDomainModule
import com.iusupov.presentation.model.FlashSalePresentationModule
import javax.inject.Inject

class FlashSaleDomainPresentationMapper @Inject constructor() :
    Mapper<FlashSaleDomainModule, FlashSalePresentationModule> {

    override fun from(i: FlashSaleDomainModule): FlashSalePresentationModule {
        return FlashSalePresentationModule(
            category = i.category,
            discount = i.discount,
            image_url = i.image_url,
            name = i.name,
            price = i.price
        )
    }

    override fun to(o: FlashSalePresentationModule): FlashSaleDomainModule {
        return FlashSaleDomainModule(
            category = o.category,
            discount = o.discount,
            image_url = o.image_url,
            name = o.name,
            price = o.price
        )
    }
}