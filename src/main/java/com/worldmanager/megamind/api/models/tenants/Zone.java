package com.worldmanager.megamind.api.models.tenants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldmanager.megamind.api.models.EntityEnum;

/**
 * AWS availability zones.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Zone implements EntityEnum<String> {
    A(Constants.A_VALUE),
    B(Constants.B_VALUE);

    public static class Constants {
        public static final String A_VALUE  = "A";
        public static final String B_VALUE  = "B";
    }

    public static final String API_PATH = "tenants.zones";
    public static final String API_COLLECTION_REF = "tenants.zones";

    private final String name;

    Zone(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static Zone forValue(final String value) {
        return EntityEnum.forValue(Zone.class, type -> type.value().equals(value))
                .orElseThrow(() -> new IllegalArgumentException("No zone found by an input value: " + value));
    }

    public String value() {
        return name;
    }
}
