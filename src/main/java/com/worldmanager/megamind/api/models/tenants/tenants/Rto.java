package com.worldmanager.megamind.api.models.tenants.tenants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldmanager.megamind.api.models.EntityEnum;

/**
 * Represents the RTOs for tenants.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Rto implements EntityEnum<String> {
    FRANKLYN_SCHOLAR("FS"),
    AVANA("AVANA"),
    ARROW("ARROW"),
    WLC("WLC"),
    ETS("ETS"),
    ARA("ARA"),
    FIRST_IMPRESSIONS("FIRST_IMPRESSIONS");

    private final String name;

    Rto(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static Rto forValue(final String value) {
        for (final Rto rto : Rto.values()) {
            if (rto.value().equals(value)) {
                return rto;
            }
        }

        throw new IllegalArgumentException("Rto not found: " + value);
    }

    public String value() {
        return name;
    }
}
