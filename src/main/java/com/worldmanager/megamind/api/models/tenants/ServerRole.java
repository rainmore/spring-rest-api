package com.worldmanager.megamind.api.models.tenants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldmanager.megamind.api.models.EntityEnum;

/**
 * Represents the possible logical roles of servers.
 *
 * @see <a href="https://worldmanager.jira.com/wiki/x/TgBYAg">Cloud Atlas</a>
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServerRole implements EntityEnum<String> {
    APPLICATION(Constants.APPLICATION_VALUE),
    DATABASE(Constants.DATABASE_VALUE),
    CHANCELLOR(Constants.CHANCELLOR_VALUE),
    STEWARD(Constants.STEWARD_VALUE);

    public static class Constants {
        public static final String APPLICATION_VALUE = "application";
        public static final String DATABASE_VALUE    = "database";
        public static final String CHANCELLOR_VALUE  = "chancellor";
        public static final String STEWARD_VALUE     = "steward";
    }

    public static final String API_PATH = "tenants.server.roles";
    public static final String API_COLLECTION_REF = "tenants.server.roles";

    private final String name;

    ServerRole(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static ServerRole forValue(final String value) {
        return EntityEnum.forValue(ServerRole.class, type -> type.value().equals(value))
                .orElseThrow(() -> new IllegalArgumentException("No role found by an input value: " + value));
    }

    public String value() {
        return name;
    }

    public Boolean hasZone() {
        return this.equals(APPLICATION) || this.equals(STEWARD);
    }

    public Boolean hasCluster() {
        return this.equals(APPLICATION) || this.equals(STEWARD) || this.equals(DATABASE);
    }

    public Boolean hasRegion() {
        return this.equals(CHANCELLOR);
    }
}
