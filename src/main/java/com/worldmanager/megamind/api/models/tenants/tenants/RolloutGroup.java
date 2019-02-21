package com.worldmanager.megamind.api.models.tenants.tenants;

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
    LIVE("live"),
    PLAYGROUND("playground"),
    PARTNER("partner"),
    DEMO("demo"),
    DEV("dev"),
    LIVE_NEW("live_new"),
    LIVE_US("live_us"),
    TEMP("temp");

    private final String name;

    RolloutGroup(final String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static RolloutGroup forValue(final String value) {
        for (final RolloutGroup group : RolloutGroup.values()) {
            if (group.value().equals(value)) {
                return group;
            }
        }

        throw new IllegalArgumentException("RolloutGroup not found: " + value);
    }

    public String value() {
        return name;
    }
}
