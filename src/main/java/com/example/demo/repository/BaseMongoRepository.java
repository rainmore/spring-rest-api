package com.example.demo.repository;

import com.example.demo.domain.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseMongoRepository<T extends Entity, ID> extends MongoRepository<T, ID> {

}
