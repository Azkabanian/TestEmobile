package com.iusupov.presentation.mapper

import com.iusupov.common.mapper.Mapper
import com.iusupov.domain.model.LatestDomainModule
import com.iusupov.presentation.model.LatestPresentationModule
import javax.inject.Inject

class LatestDomainPresentationMapper @Inject constructor() :
    Mapper<LatestDomainModule, LatestPresentationModule> {

    override fun from(i: LatestDomainModule): LatestPresentationModule {
        return LatestPresentationModule(
            category = i.category,
            image_url = i.image_url,
            name = i.name,
            price = i.price
        )
    }

    override fun to(o: LatestPresentationModule): LatestDomainModule {
        return LatestDomainModule(
            category = o.category,
            image_url = o.image_url,
            name = o.name,
            price = o.price
        )
    }
}