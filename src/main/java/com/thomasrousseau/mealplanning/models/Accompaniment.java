package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.AccompanimentContract;
import com.thomasrousseau.mealplanning.database.contracts.IngredientContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Define the Day object.
 */
@Entity
@Table(name = AccompanimentContract.TABLE)
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = AccompanimentContract.COL_ID))
public class Accompaniment extends EntityBase {

    @Column(name = IngredientContract.COL_NAME, nullable = false, unique = true)
    @JsonProperty(value = IngredientContract.COL_NAME)
    private String name;

}
