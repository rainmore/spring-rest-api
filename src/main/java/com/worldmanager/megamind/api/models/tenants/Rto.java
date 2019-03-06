package com.worldmanager.megamind.api.models.tenants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldmanager.megamind.api.models.EntityEnum;

/**
 * Represents the RTOs for tenants.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Rto implements EntityEnum<String> {
    FRANKLYN_SCHOLAR(Constants.FRANKLYN_SCHOLAR_VALUE),
    AVANA(Constants.AVANA_VALUE),
    ARROW(Constants.ARROW_VALUE),
    WLC(Constants.WLC_VALUE),
    ETS(Constants.ETS_VALUE),
    ARA(Constants.ARA_VALUE),
    FIRST_IMPRESSIONS(Constants.FIRST_IMPRESSIONS_VALUE);

    public static class Constants {
        public static final String FRANKLYN_SCHOLAR_VALUE  = "FS";
        public static final String AVANA_VALUE             = "AVANA";
        public static final String ARROW_VALUE             = "ARROW";
        public static final String WLC_VALUE               = "WLC";
        public static final String ETS_VALUE               = "ETS";
        public static final String ARA_VALUE               = "ARA";
        public static final String FIRST_IMPRESSIONS_VALUE = "FIRST_IMPRESSIONS";
    }

    public static final String API_PATH = "tenants.rtoes";
    public static final String API_COLLECTION_REF = "tenants.rtoes";

    private final String name;

    Rto(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static Rto forValue(final String value) {
        return EntityEnum.forValue(Rto.class, type -> type.value().equals(value))
                .orElseThrow(() -> new IllegalArgumentException("No RTO found by an input value: " + value));
    }

    public String value() {
        return name;
    }
}
