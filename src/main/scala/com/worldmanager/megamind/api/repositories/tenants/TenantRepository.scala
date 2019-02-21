package com.worldmanager.megamind.api.repositories.tenants

import com.worldmanager.megamind.api.models.tenants.tenants.Tenant
import com.worldmanager.megamind.api.repositories.BaseMongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.{RepositoryRestResource, RestResource}

@RepositoryRestResource(collectionResourceRel = "tenants", path = "tenants")
trait TenantRepository extends BaseMongoRepository[Tenant, String] {

    @RestResource
    def findOneByTenantId(@Param("tenantId") tenantId: String): Tenant

    @RestResource
    def findOneByName(@Param("name") tenantId: String): Tenant

    @RestResource
    def findOneBySystemId(@Param("systemId") systemId: Long): Tenant
}
