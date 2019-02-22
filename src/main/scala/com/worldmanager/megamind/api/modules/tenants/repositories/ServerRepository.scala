package com.worldmanager.megamind.api.modules.tenants.repositories

import com.worldmanager.megamind.api.models.tenants.{Role, Server}
import com.worldmanager.megamind.api.modules.BaseMongoRepository
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.{RepositoryRestResource, RestResource}

@RepositoryRestResource(path = Server.API_PATH, collectionResourceRel = Server.API_COLLECTION_REF)
trait ServerRepository[T <: Server] extends BaseMongoRepository[T, String] {

    @RestResource
    def findByName(@Param("name") name: String): T

    @RestResource
    def findByRole(@Param("role") role: Role, pageable: Pageable): Page[T]
}
