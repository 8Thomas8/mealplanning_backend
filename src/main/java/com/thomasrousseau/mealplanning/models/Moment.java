package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.MomentContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.MomentName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

/**
 * Define the Moment object.
 */
@Entity
@Table(name = MomentContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = MomentContract.COL_ID))
public class Moment extends EntityBase {

    /**
     * The name of the Moment.
     */
    @Column(name = MomentContract.COL_NAME, nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty(value = MomentContract.COL_NAME)
    private MomentName name;

    /**
     * The guest number of the Moment.
     */
    @Column(name = MomentContract.COL_GUEST_NUMBER, nullable = false)
    @JsonProperty(value = MomentContract.COL_GUEST_NUMBER)
    private int guestNumber;

    /**
     * Collection of meals from the association with Meal.
     */
    @ManyToMany
    @JsonProperty(value = "meals")
    private Collection<Meal> meals;
}
