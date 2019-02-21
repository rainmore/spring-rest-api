package com.worldmanager.megamind.api.models.tenants.servers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldmanager.megamind.api.models.EntityEnum;

/**
 * AWS availability zones.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Zone implements EntityEnum<String> {
    A("A"),
    B("B");

    private final String name;

    Zone(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static Zone forValue(final String value) {
        for (final Zone zone : Zone.values()) {
            if (zone.value().equals(value)) {
                return zone;
            }
        }

        throw new IllegalArgumentException("Zone not found: " + value);
    }

    public String value() {
        return name;
    }
}
