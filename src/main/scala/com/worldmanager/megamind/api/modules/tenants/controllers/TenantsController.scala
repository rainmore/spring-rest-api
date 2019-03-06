package com.worldmanager.megamind.api.modules.tenants.controllers

import com.worldmanager.megamind.api.models.tenants._
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
        val resources = new Resources[Rto](Rto.values().toSeq.asJava)
        resources.add(linkTo(methodOn(this.getClass).getRtos()).withSelfRel())
        ResponseEntity.ok(resources)
    }

    @GetMapping(Array("/" + RolloutGroup.API_PATH))
    def getRolloutGroups(): ResponseEntity[Resources[RolloutGroup]] = {
        val resources = new Resources[RolloutGroup](RolloutGroup.values().toSeq.asJava)
        resources.add(linkTo(methodOn(this.getClass).getRolloutGroups()).withSelfRel())
        ResponseEntity.ok(resources)
    }

    @GetMapping(Array("/" + ServerRole.API_PATH))
    def getServerRoles(): ResponseEntity[Resources[ServerRole]] = {
        val resources = new Resources[ServerRole](ServerRole.values().toSeq.asJava)
        resources.add(linkTo(methodOn(this.getClass).getServerRoles()).withSelfRel())
        ResponseEntity.ok(resources)
    }

    @GetMapping(Array("/" + Zone.API_PATH))
    def getZones(): ResponseEntity[Resources[Zone]] = {
        val resources = new Resources[Zone](Zone.values().toSeq.asJava)
        resources.add(linkTo(methodOn(this.getClass).getZones()).withSelfRel())
        ResponseEntity.ok(resources)
    }
}
