package com.thomasrousseau.mealplanning.models.enumerations;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration of moment's name.
 */
@RequiredArgsConstructor
@Getter
public enum MomentName {
    MIDI(0, "Midi"),
    SOIR(1, "Soir");


    private final int value;

    @NonNull
    @JsonValue
    private final String label;
}
