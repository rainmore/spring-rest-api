package com.worldmanager.megamind.api.modules.tenants.repositories

import com.worldmanager.megamind.api.models.tenants.Tenant
import com.worldmanager.megamind.api.modules.BaseMongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.{RepositoryRestResource, RestResource}

@RepositoryRestResource(path = Tenant.API_PATH, collectionResourceRel = Tenant.API_COLLECTION_REF)
trait TenantRepository extends BaseMongoRepository[Tenant, String] {

    @RestResource
    def findOneByTenantId(@Param("tenantId") tenantId: String): Tenant

    @RestResource
    def findOneByName(@Param("name") tenantId: String): Tenant

    @RestResource
    def findOneBySystemId(@Param("systemId") systemId: Long): Tenant
}
