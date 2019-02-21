package com.worldmanager.megamind.api.repositories

import java.io.Serializable

import com.worldmanager.megamind.api.models.Entity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
trait BaseMongoRepository[T <: Entity, ID <: Serializable] extends MongoRepository[T, ID]