package com.worldmanager.megamind.api.models.tenants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.worldmanager.megamind.api.models.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.Instant;

@Document(collection = Tenant.COLLECTION_NAME)
@TypeAlias(value = Tenant.COLLECTION_NAME)
public class Tenant implements Entity {

    public static final String COLLECTION_NAME = "tenants";
    public static final String API_PATH           = "tenants.tenants";
    public static final String API_COLLECTION_REF = "tenants.tenants";


    @DBRef
    private Cluster      cluster;
    private String       id;
    private Long         originalId;
    private Long         systemId;
    private String       tenantId;
    private String       name;
    private String       contentPath;
    private Boolean      active     = false;
    private String       platformUrl;
    private String       tag;
    private RolloutGroup rolloutGroup;
    private Instant      createdAt;
    private Instant      updatedAt;
    private Instant      syncedAt   = Instant.now();
    private Database     database   = new Database();
    private T2Settings   t2Settings = new T2Settings();

    @Field("cluster")
    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(final Cluster cluster) {
        this.cluster = cluster;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @JsonIgnore
    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(final Long originalId) {
        this.originalId = originalId;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(final Long systemId) {
        this.systemId = systemId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(final String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(final String contentPath) {
        this.contentPath = contentPath;
    }

    @Transient
    public String getPlatformUrl() {
        return platformUrl;
    }

    public void setPlatformUrl(final String platformUrl) {
        this.platformUrl = platformUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public RolloutGroup getRolloutGroup() {
        return rolloutGroup;
    }

    public void setRolloutGroup(final RolloutGroup rolloutGroup) {
        this.rolloutGroup = rolloutGroup;
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

    public Instant getSyncedAt() {
        return syncedAt;
    }

    public void setSyncedAt(final Instant syncedAt) {
        this.syncedAt = syncedAt;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(final Database database) {
        this.database = database;
    }

    public T2Settings getT2Settings() {
        return t2Settings;
    }

    public void setT2Settings(final T2Settings t2Settings) {
        this.t2Settings = t2Settings;
    }
}
