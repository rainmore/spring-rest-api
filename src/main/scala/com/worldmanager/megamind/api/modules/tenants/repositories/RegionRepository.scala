package com.worldmanager.megamind.api.modules.tenants.repositories

import com.worldmanager.megamind.api.models.tenants.Region
import com.worldmanager.megamind.api.modules.BaseMongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = Region.API_PATH, collectionResourceRel = Region.API_COLLECTION_REF)
trait RegionRepository extends BaseMongoRepository[Region, String]{

    def findOneByName(@Param("name") name: String): Region
}
