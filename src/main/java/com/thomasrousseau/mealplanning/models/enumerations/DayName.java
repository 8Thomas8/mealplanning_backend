package com.thomasrousseau.mealplanning.models.enumerations;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration of day's name.
 */
@RequiredArgsConstructor
@Getter
public enum DayName {
    LUNDI(0, "Lundi"),
    MARDI(1, "Mardi"),
    MERCREDI(2, "Mercredi"),
    JEUDI(3, "Jeudi"),
    VENDREDI(4, "Vendredi"),
    SAMEDI(5, "Samedi"),
    DIMANCHE(6, "Dimanche");

    private final int value;

    @NonNull
    @JsonValue
    private final String label;
}
