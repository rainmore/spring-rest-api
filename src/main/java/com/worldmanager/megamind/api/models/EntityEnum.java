package com.worldmanager.megamind.api.models;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public interface EntityEnum<Type> {
    Type value();

    /**
     * Finds a first occurrence among constants of an implementing enum that corresponds to a comparison function.
     * This method can be used to reduce a boiler plate logic of searching an appropriate enum constant by a provided value.
     *
     * @param enumClass A class of an implementing enum.
     * @param comparisonFunction A comparison function.
     * @param <E> The type of an implementing enum.
     * @return An optional of a found enum constant.
     */
    static <E extends Enum<E>> Optional<E> forValue(Class<E> enumClass, Predicate<E> comparisonFunction) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(comparisonFunction)
                .findFirst();
    }
}
