package com.worldmanager.megamind.api.models.tenants.servers;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.worldmanager.megamind.api.models.tenants.regions.Region;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(Role.Constants.CHANCELLOR_VALUE)
@JsonTypeName(Role.Constants.CHANCELLOR_VALUE)
@TypeAlias(value = Role.Constants.CHANCELLOR_VALUE)
public class Chancellor extends Server {

    public static final String REGION_FIELD = "region";

    @DBRef
    private Region region;

    @Field(REGION_FIELD)
    public Region getRegion() {
        return region;
    }

    public void setRegion(final Region region) {
        this.region = region;
    }
}
