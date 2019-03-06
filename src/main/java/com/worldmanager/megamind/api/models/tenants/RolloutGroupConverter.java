package com.worldmanager.megamind.api.models.tenants;

import com.worldmanager.megamind.api.models.EntityEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class RolloutGroupConverter extends EntityEnumConverter<RolloutGroup, String> {

    @Override
    public RolloutGroup convertToEntityAttribute(String dbData) {
        return RolloutGroup.forValue(dbData);
    }
}

