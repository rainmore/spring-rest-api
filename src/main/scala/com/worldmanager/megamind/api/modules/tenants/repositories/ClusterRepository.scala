package com.worldmanager.megamind.api.modules.tenants.repositories

import com.worldmanager.megamind.api.models.tenants.{Cluster, Region}
import com.worldmanager.megamind.api.modules.BaseMongoRepository
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = Cluster.API_PATH, collectionResourceRel = Cluster.API_COLLECTION_REF)
trait ClusterRepository extends BaseMongoRepository[Cluster, String] {

    def findByName(@Param("name") name: String): Cluster

    def findByRegion(@Param("region") region: Region, pageable: Pageable): Page[Cluster]
}
