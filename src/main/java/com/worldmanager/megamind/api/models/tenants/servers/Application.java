package com.worldmanager.megamind.api.models.tenants.servers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.worldmanager.megamind.api.models.tenants.clusters.Cluster;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(Role.Constants.APPLICATION_VALUE)
@JsonTypeName(Role.Constants.APPLICATION_VALUE)
@TypeAlias(value = Role.Constants.APPLICATION_VALUE)
public class Application extends Server {

    public static final String CLUSTER_FIELD = "cluster";

    @DBRef
    private Cluster cluster;
    private Zone    zone;

    @Field(CLUSTER_FIELD)
    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(final Cluster cluster) {
        this.cluster = cluster;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Zone getZone() {
        return zone;
    }

    public void setZone(final Zone zone) {
        this.zone = zone;
    }
}
