package com.worldmanager.megamind.api.models.tenants;

import com.worldmanager.megamind.api.models.EntityEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class RtoConverter extends EntityEnumConverter<Rto, String> {

    @Override
    public Rto convertToEntityAttribute(String dbData) {
        return Rto.forValue(dbData);
    }
}