package com.worldmanager.megamind.api.models;

import javax.persistence.AttributeConverter;

public abstract class EntityEnumConverter<T extends EntityEnum<V>, V> implements AttributeConverter<T, V> {

    @Override
    public V convertToDatabaseColumn(T attribute) {
        return attribute.value();
    }

    @Override
    public abstract T convertToEntityAttribute(V dbData);
}
