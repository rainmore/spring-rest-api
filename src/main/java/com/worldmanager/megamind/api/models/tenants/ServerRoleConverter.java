package com.worldmanager.megamind.api.models.tenants;

import com.worldmanager.megamind.api.models.EntityEnumConverter;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ServerRoleConverter extends EntityEnumConverter<ServerRole, String> {

    @Override
    public ServerRole convertToEntityAttribute(String dbData) {
        return ServerRole.forValue(dbData);
    }
}

