package com.worldmanager.megamind.api.models.tenants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.worldmanager.megamind.api.models.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.DiscriminatorColumn;
import java.time.Instant;

@Document(collection = Server.COLLECTION_NAME)
@DiscriminatorColumn(name = Server.ROLE_FIELD)
public abstract class Server implements Entity {

    public static final String COLLECTION_NAME = "servers";
    public static final String ROLE_FIELD      = "role";

    public static final String API_PATH = "tenants.servers";
    public static final String API_COLLECTION_REF = "tenants.servers";

    private String     id;
    private String     name;
    private String     host;
    private ServerRole role;
    private Boolean    active = false;
    private Instant    createdAt;
    private Instant    updatedAt;

    private Zone    zone;

    @DBRef
    private Region  region;

    @DBRef
    private Cluster cluster;


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

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public ServerRole getRole() {
        return role;
    }

    public void setRole(final ServerRole role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
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

    public void setUpdatedAt(final Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Zone getZone() {
        return zone;
    }

    public void setZone(final Zone zone) {
        this.zone = zone;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(final Cluster cluster) {
        this.cluster = cluster;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(final Region region) {
        this.region = region;
    }

}
