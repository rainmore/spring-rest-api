package com.worldmanager.megamind.api.repositories.tenants

import com.worldmanager.megamind.api.models.tenants.clusters.Cluster
import com.worldmanager.megamind.api.models.tenants.regions.Region
import com.worldmanager.megamind.api.repositories.BaseMongoRepository
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.{RepositoryRestResource, RestResource}

@RepositoryRestResource(collectionResourceRel = "tenants.clusters", path = "tenants.clusters")
trait ClusterRepository extends BaseMongoRepository[Cluster, String] {

    def findByName(@Param("name") name: String): Cluster

    def findByRegion(@Param("region") region: Region, pageable: Pageable): Page[Cluster]
}
