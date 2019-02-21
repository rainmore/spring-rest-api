package com.example.demo.repository;

import com.example.demo.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "tenants.regions", collectionResourceRel = "tenants.regions")
public interface RegionRepository extends BaseMongoRepository<Region, String> {

    @RestResource(path = "names", rel = "names")
    public Page<Region> findByName(@Param("name") String name, Pageable pageable);
}
