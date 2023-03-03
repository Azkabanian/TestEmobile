package com.iusupov.data.mapper

import com.iusupov.common.mapper.Mapper
import com.iusupov.data.model.LatestDataModule
import com.iusupov.domain.model.LatestDomainModule
import javax.inject.Inject

class LatestDataDomainMapper @Inject constructor()
    : Mapper<LatestDataModule, LatestDomainModule> {

    override fun from(i: LatestDataModule): LatestDomainModule {
        return LatestDomainModule(
            category = i.category,
            image_url = i.image_url,
            name = i.name,
            price = i.price
        )
    }

    override fun to(o: LatestDomainModule): LatestDataModule {
        return LatestDataModule(
            category = o.category,
            image_url = o.image_url,
            name = o.name,
            price = o.price
        )
    }
}