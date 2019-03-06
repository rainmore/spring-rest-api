package com.worldmanager.megamind.api.modules.tenants

import com.worldmanager.megamind.api.models.tenants.{Rto, Tenant}
import com.worldmanager.megamind.api.modules.tenants.controllers.TenantsController
import javax.inject.Inject
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.RepositoryLinksResource
import org.springframework.data.rest.webmvc.config.{RepositoryRestConfigurer, RepositoryRestMvcConfiguration}
import org.springframework.hateoas.{EntityLinks, PagedResources, Resource, ResourceProcessor}
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.mvc.ControllerLinkBuilder.{linkTo, methodOn}

@Configuration
class TenantRestConfiguration extends RepositoryRestConfigurer {

    @Bean
    @Inject
    def tenantsRtoesResourceProcessor(configuration: RepositoryRestMvcConfiguration): ResourceProcessor[RepositoryLinksResource] = {
        new ResourceProcessor[RepositoryLinksResource] {
            override def process(resource: RepositoryLinksResource): RepositoryLinksResource = {

                val link = ControllerLinkBuilder.linkTo(methodOn(classOf[TenantsController]).getRtos()).withRel(Rto.API_COLLECTION_REF)
                resource.add(link)
                resource
            }
        }
    }

    override def configureRepositoryRestConfiguration(config: RepositoryRestConfiguration): Unit = {
        super.configureRepositoryRestConfiguration(config)
    }
}
