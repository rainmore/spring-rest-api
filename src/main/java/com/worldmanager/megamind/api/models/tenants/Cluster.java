package com.worldmanager.megamind.api.models.tenants;

import com.worldmanager.megamind.api.models.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;


@Document(collection = Cluster.COLLECTION_NAME)
@TypeAlias(value = Cluster.COLLECTION_NAME)
public class Cluster implements Entity {

    public static final String COLLECTION_NAME    = "clusters";
    public static final String API_PATH           = "tenants.clusters";
    public static final String API_COLLECTION_REF = "tenants.clusters";

    @DBRef
    private Region  region;
    private String  id;
    private String  name;
    private Instant createdAt;
    private Instant updatedAt;

    @Field("region")
    public Region getRegion() {
        return region;
    }

    public void setRegion(final Region region) {
        this.region = region;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @CreatedDate
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Instant createdAt) {
        this.createdAt = createdAt;
    }

    @LastModifiedDate
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
