package com.iusupov.network.mapper

import com.iusupov.common.mapper.Mapper
import com.iusupov.data.model.LatestDataModule
import com.iusupov.network.model.LatestNetworkModule
import javax.inject.Inject

class LatestNetworkDataMapper @Inject constructor()
    : Mapper<LatestNetworkModule, LatestDataModule> {

    override fun from(i: LatestNetworkModule): LatestDataModule {
        return LatestDataModule(
            category = i.category,
            image_url = i.image_url,
            name = i.name,
            price = i.price
        )
    }

    override fun to(o: LatestDataModule): LatestNetworkModule {
        return LatestNetworkModule(
            category = o.category,
            image_url = o.image_url,
            name = o.name,
            price = o.price
        )
    }
}