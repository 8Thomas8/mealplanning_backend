package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.SlotContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.MomentName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Define the Day object.
 */
@Entity
@Table(name = SlotContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = SlotContract.COL_ID))
public class Slot extends EntityBase {

    /**
     * The name of the planning.
     */
    @Column(name = SlotContract.COL_DATE, nullable = false)
    @JsonProperty(value = SlotContract.COL_DATE)
    private Date date;

    /**
     * The name of the Moment.
     */
    @Column(name = SlotContract.COL_MOMENT_NAME, nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty(value = SlotContract.COL_MOMENT_NAME)
    private MomentName name;

    /**
     * The guest number of the Moment.
     */
    @Column(name = SlotContract.COL_GUEST_NUMBER, nullable = false)
    @JsonProperty(value = SlotContract.COL_GUEST_NUMBER)
    private int guestNumber;

    /**
     * Collection of meals from the association with Meal.
     */
    @OneToMany
    @JsonProperty(value = "meals")
    private Collection<Meal> meals;
}
