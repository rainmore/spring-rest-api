package com.worldmanager.megamind.api.modules.helpers

import org.springframework.data.domain.{Page, Pageable, PageImpl}

import scala.collection.JavaConverters._

object PageableList {

    /**
     * Allow a list to be treated as a pageable.
     *
     * @param values the list to make pageable.
     * @param pageable the current page information.
     * @return page data containing the list.
     */
    def apply[T](values: List[T], pageable: Pageable): Page[T] = {
        val size   = pageable.getPageSize
        val offset = pageable.getOffset.toInt
        val data   = values.slice(offset, offset + size).asJava

        new PageImpl(data, pageable, values.size)
    }
}