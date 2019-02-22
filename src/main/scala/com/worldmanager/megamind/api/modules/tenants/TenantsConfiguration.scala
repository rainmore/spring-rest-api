package com.worldmanager.megamind.api.modules.tenants

import com.worldmanager.megamind.api.models.tenants.Rto
import com.worldmanager.megamind.api.modules.tenants.controllers.RtoController
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.{Resource, ResourceProcessor}

@Configuration
class TenantsConfiguration {

    @Bean
    def rtoResourceProcessor: ResourceProcessor[Resource[Rto]] = {
        new ResourceProcessor[Resource[Rto]] {
            override def process(resource: Resource[Rto]): Resource[Rto] = {
                val rto = resource.getContent
                resource.add(ControllerLinkBuilder.linkTo(
                    ControllerLinkBuilder.methodOn(
                        classOf[RtoController]).findById(rto.value())
                ).withSelfRel())
                resource
            }
        }
    }

}
