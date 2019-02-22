package com.worldmanager.megamind.api.modules.tenants.controllers

import com.worldmanager.megamind.api.models.tenants.Rto
import com.worldmanager.megamind.api.modules.helpers.PageableList
import javax.inject.Inject
import org.springframework.data.domain.Pageable
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.{MediaTypes, PagedResources, Resource}
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation._

object RtoController {
    final val BaseMapping = "/tenants/search/rtoes"
}

@RepositoryRestController
@RequestMapping(Array(RtoController.BaseMapping))
class RtoController @Inject()
(
    resourcesAssembler: PagedResourcesAssembler[Rto]
) {

    /**
      * Retrieve all RTOs.
      *
      * @param pageable page information.
      * @return a `ResponseEntity` that contains the result of the call.
      */
    @GetMapping(produces = Array(MediaTypes.HAL_JSON_VALUE))
    def findAll(pageable: Pageable): ResponseEntity[PagedResources[Resource[Rto]]] = {
        val rtos = PageableList(Rto.values.toList, pageable)
        val resource = resourcesAssembler.toResource(rtos)
        ResponseEntity.ok(resource)
    }

    /**
      * Retrieve an RTO by it's ID (name).
      *
      * Will return status codes:
      *   - 200 when the rto exists
      *   - 404 when the rto is not found
      *
      * @param id the ID associated with an RTO.
      * @return a `ResponseEntity` that contains the result of the call.
      */
    @GetMapping(Array("/{id}"))
    def findById(@PathVariable id: String): ResponseEntity[Resource[Rto]] = {
        Option(Rto.forValue(id))
            .map(rto => ResponseEntity.ok(new Resource(rto)))
            .getOrElse(ResponseEntity.notFound().build())
    }
}
