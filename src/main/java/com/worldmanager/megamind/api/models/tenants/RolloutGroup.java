package com.worldmanager.megamind.api.models.tenants;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldmanager.megamind.api.models.EntityEnum;

/**
 * Represents the release groups for tenants.
 *
 * @see <a href="https://worldmanager.jira.com/wiki/x/eQDPAQ">Build System</a>
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RolloutGroup implements EntityEnum<String> {
    LIVE(Constants.LIVE_VALUE),
    PLAYGROUND(Constants.PLAYGROUND_VALUE),
    PARTNER(Constants.PARTNER_VALUE),
    DEMO(Constants.DEMO_VALUE),
    DEV(Constants.DEV_VALUE),
    LIVE_NEW(Constants.LIVE_NEW_VALUE),
    LIVE_US(Constants.LIVE_US_VALUE),
    TEMP(Constants.TEMP_VALUE);

    public static class Constants {
        public static final String LIVE_VALUE       = "live";
        public static final String PLAYGROUND_VALUE = "playground";
        public static final String PARTNER_VALUE    = "partner";
        public static final String DEMO_VALUE       = "demo";
        public static final String DEV_VALUE        = "dev";
        public static final String LIVE_NEW_VALUE   = "live_new";
        public static final String LIVE_US_VALUE    = "live_us";
        public static final String TEMP_VALUE       = "temp";
    }

    public static final String API_PATH = "tenants.rolloutGroups";
    public static final String API_COLLECTION_REF = "tenants.rolloutGroups";


    private final String name;

    RolloutGroup(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static RolloutGroup forValue(final String value) {
        return EntityEnum.forValue(RolloutGroup.class, type -> type.value().equals(value))
                .orElseThrow(() -> new IllegalArgumentException("No rollout group found by an input value: " + value));
    }

    public String value() {
        return name;
    }
}
