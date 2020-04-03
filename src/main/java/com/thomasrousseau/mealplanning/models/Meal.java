package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.MealContract;
import com.thomasrousseau.mealplanning.database.contracts.MeatContract;
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
@Table(name = MealContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = MealContract.COL_ID))
public class Meal extends EntityBase {

    /**
     * The name of the Moment.
     */
    @Column(name = MealContract.COL_NAME, nullable = false)
    @JsonProperty(value = MealContract.COL_NAME)
    private String name;

    /**
     * Collection of accompaniments from Accompaniment relation.
     */
    @ManyToMany
    @JsonProperty(value = "accompaniments")
    private Collection<Accompaniment> accompaniments;

    /**
     * Collection of meals from Meal relation.
     */
    @ManyToMany
    @JsonProperty(value = "meals")
    private Collection<Meal> meals;
}
