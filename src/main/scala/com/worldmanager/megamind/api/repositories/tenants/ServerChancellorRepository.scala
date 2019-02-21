package com.worldmanager.megamind.api.repositories.tenants

import com.worldmanager.megamind.api.models.tenants.servers.Chancellor
import com.worldmanager.megamind.api.repositories.BaseMongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * This is an empty class required for Spring Data REST to process entities.
 */
@RepositoryRestResource(collectionResourceRel = "tenants.servers.chancellor", path = "tenants.servers.chancellor")
trait ServerChancellorRepository extends BaseMongoRepository[Chancellor, String]
