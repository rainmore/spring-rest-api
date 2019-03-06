package com.worldmanager.megamind.api.models.tenants;

import com.worldmanager.megamind.api.models.EntityEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ZoneConverter extends EntityEnumConverter<Zone, String> {

    @Override
    public Zone convertToEntityAttribute(String dbData) {
        return Zone.forValue(dbData);
    }
}
