package com.worldmanager.megamind.api.repositories.tenants

import com.worldmanager.megamind.api.models.tenants.servers.Database
import com.worldmanager.megamind.api.repositories.BaseMongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * This is an empty class required for Spring Data REST to process entities.
 */
@RepositoryRestResource(collectionResourceRel = "tenants.servers.database", path = "tenants.servers.database")
trait ServerDatabaseRepository extends BaseMongoRepository[Database, String]
