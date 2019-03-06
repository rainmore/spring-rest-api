package com.worldmanager.megamind.api.modules.tenants.controllers

import com.worldmanager.megamind.api.models.tenants.{Rto, Tenant}
import com.worldmanager.megamind.api.modules.helpers.PageableList
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.{PagedResources, Resource, Resources}
import org.springframework.hateoas.mvc.ControllerLinkBuilder.{linkTo, methodOn}
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping}

import scala.collection.JavaConverters._

object TenantsController {
    final val BaseMapping = "/" + Tenant.API_PATH
}

@RepositoryRestController
@RequestMapping(Array(TenantsController.BaseMapping))
class TenantsController {

    @GetMapping(Array("/" + Rto.API_PATH))
    def getRtos(): ResponseEntity[Resources[Rto]] = {
        val rtoes = Rto.values().map(new Resource[Rto](_)).toSeq
        val resources = new Resources[Rto](Rto.values().toSeq.asJava)
        resources.add(linkTo(methodOn(this.getClass).getRtos()).withSelfRel())
        ResponseEntity.ok(resources)
    }
}
