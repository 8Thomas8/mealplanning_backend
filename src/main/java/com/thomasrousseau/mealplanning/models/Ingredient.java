package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.IngredientContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Define the Ingredient base object.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Ingredient extends EntityBase {

    @Column(name = IngredientContract.COL_NAME, nullable = false, unique = true)
    private String name;
}
