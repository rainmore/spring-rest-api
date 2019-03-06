package com.worldmanager.megamind.api.modules.tenants

import com.worldmanager.megamind.api.models.tenants._
import com.worldmanager.megamind.api.modules.tenants.controllers.TenantsController
import javax.inject.Inject
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.data.rest.webmvc.RepositoryLinksResource
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
import org.springframework.hateoas.ResourceProcessor
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn

@Configuration
class TenantRestConfiguration {

    /**
      * Register tenants enums to the root resources list
      *
      * @param configuration
      * @return
      */
    @Bean
    @Inject
    def tenantsResourceProcessor(configuration: RepositoryRestMvcConfiguration): ResourceProcessor[RepositoryLinksResource] = {
        new ResourceProcessor[RepositoryLinksResource] {
            override def process(resource: RepositoryLinksResource): RepositoryLinksResource = {
                val methods = methodOn(classOf[TenantsController])

                resource.add(ControllerLinkBuilder.linkTo(methods.getRtos()).withRel(Rto.API_COLLECTION_REF))
                resource.add(ControllerLinkBuilder.linkTo(methods.getRolloutGroups()).withRel(RolloutGroup.API_COLLECTION_REF))
                resource.add(ControllerLinkBuilder.linkTo(methods.getServerRoles()).withRel(ServerRole.API_COLLECTION_REF))
                resource.add(ControllerLinkBuilder.linkTo(methods.getZones()).withRel(Zone.API_COLLECTION_REF))
                resource
            }
        }
    }

}
