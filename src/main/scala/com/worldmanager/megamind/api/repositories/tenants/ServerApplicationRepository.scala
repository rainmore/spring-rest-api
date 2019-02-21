package com.worldmanager.megamind.api.repositories.tenants

import com.worldmanager.megamind.api.models.tenants.servers.Application
import com.worldmanager.megamind.api.repositories.BaseMongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * This is an empty class required for Spring Data REST to process entities.
 */
@RepositoryRestResource(collectionResourceRel = "tenants.servers.application", path = "tenants.servers.application")
trait ServerApplicationRepository extends BaseMongoRepository[Application, String]
