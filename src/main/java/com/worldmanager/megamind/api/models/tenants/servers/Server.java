package com.worldmanager.megamind.api.models.tenants.servers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.worldmanager.megamind.api.models.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.DiscriminatorColumn;
import java.time.Instant;

@Document(collection = Server.COLLECTION_NAME)
@DiscriminatorColumn(name = Server.ROLE_FIELD)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = Server.ROLE_FIELD, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Chancellor.class),
        @JsonSubTypes.Type(value = Database.class),
        @JsonSubTypes.Type(value = Application.class),
        @JsonSubTypes.Type(value = Steward.class)
})
public abstract class Server implements Entity {

    public static final String COLLECTION_NAME = "servers";
    public static final String ROLE_FIELD      = "role";

    private String   id;
    private String   name;
    private String   host;
    private Role     role;
    private Boolean  active = false;
    private Instant  createdAt;
    private Instant updatedAt;

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
    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
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
}
