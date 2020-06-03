package com.thomasrousseau.mealplanning.models.enumerations;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration of user's role authorized.
 */
@RequiredArgsConstructor
@Getter
public enum UserRole {
    ADMIN(0, "Admin"),
    USER(1, "User");

    private final int value;

    @NonNull
    @JsonValue
    private final String label;
}
