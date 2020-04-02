package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.MealContract;
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
    private String name;

    /**
     * Collection of accompaniments from Accompaniment relation.
     */
    @ManyToMany
    private Collection<Accompaniment> accompaniments;

    /**
     * Collection of meals from Meal relation.
     */
    @ManyToMany
    private Collection<Meal> meals;
}
