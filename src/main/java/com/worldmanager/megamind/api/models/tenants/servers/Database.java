package com.worldmanager.megamind.api.models.tenants.servers;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.worldmanager.megamind.api.models.tenants.clusters.Cluster;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(Role.Constants.DATABASE_VALUE)
@JsonTypeName(Role.Constants.DATABASE_VALUE)
@TypeAlias(value = Role.Constants.DATABASE_VALUE)
public class Database extends Server {

    public static final String CLUSTER_FIELD = "cluster";

    @DBRef
    private Cluster cluster;

    @Field(CLUSTER_FIELD)
    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(final Cluster cluster) {
        this.cluster = cluster;
    }
}
