package com.worldmanager.megamind.api.models.tenants.servers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldmanager.megamind.api.models.EntityEnum;

/**
 * Represents the possible logical roles of servers.
 *
 * @see <a href="https://worldmanager.jira.com/wiki/x/TgBYAg">Cloud Atlas</a>
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Role implements EntityEnum<String> {
    APPLICATION(Constants.APPLICATION_VALUE),
    DATABASE(Constants.DATABASE_VALUE),
    CHANCELLOR(Constants.CHANCELLOR_VALUE),
    STEWARD(Constants.STEWARD_VALUE);

    private final String name;

    Role(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static Role forValue(final String value) {
        for (final Role role : Role.values()) {
            if (role.value().equals(value)) {
                return role;
            }
        }

        throw new IllegalArgumentException("Role not found: " + value);
    }

    public String value() {
        return name;
    }

    public static class Constants {
        public static final String APPLICATION_VALUE = "application";
        public static final String DATABASE_VALUE    = "database";
        public static final String CHANCELLOR_VALUE  = "chancellor";
        public static final String STEWARD_VALUE     = "steward";
    }
}
