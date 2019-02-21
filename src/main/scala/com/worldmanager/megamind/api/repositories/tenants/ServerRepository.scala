package com.worldmanager.megamind.api.repositories.tenants

import com.worldmanager.megamind.api.models.tenants.servers.{Role, Server}
import com.worldmanager.megamind.api.repositories.BaseMongoRepository
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.{RepositoryRestResource, RestResource}

@RepositoryRestResource(collectionResourceRel = "tenants.servers", path = "tenants.servers")
trait ServerRepository[T <: Server] extends BaseMongoRepository[T, String] {

    @RestResource
    def findByName(@Param("name") name: String): T

    @RestResource
    def findByRole(@Param("role") role: Role, pageable: Pageable): Page[T]
}
