package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.DayContract;
import com.thomasrousseau.mealplanning.database.contracts.IngredientContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.DayName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

/**
 * Define the Day object.
 */
@Entity
@Table(name = DayContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = DayContract.COL_ID))
public class Day extends EntityBase {

    /**
     * The name of the planning.
     */
    @Column(name = DayContract.COL_NAME, nullable = false)
    @JsonProperty(value = DayContract.COL_NAME)
    @Enumerated(EnumType.STRING)
    private DayName name;

    /**
     * Moments from the association with Moment.
     */
    @ManyToMany
    @JsonProperty(value = "moments")
    private Collection<Moment> moments;
}
