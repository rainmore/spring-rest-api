package com.worldmanager.megamind.api.repositories.tenants


import com.worldmanager.megamind.api.models.tenants.regions.Region
import com.worldmanager.megamind.api.repositories.BaseMongoRepository
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.{RepositoryRestResource, RestResource}

@RepositoryRestResource(path = "tenants.regions", collectionResourceRel = "tenants.regions")
trait RegionRepository extends BaseMongoRepository[Region, String]{

    def findOneByName(@Param("name") name: String): Region
}
