package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.MeatContract;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Define the Day object.
 */
@Entity
@Table(name = MeatContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = MeatContract.COL_ID))
public class Meat extends Ingredient {

    /**
     * The number of piece by person.
     */
    @Column(name = MeatContract.COL_NUMBER_BY_PERSON, nullable = false)
    @JsonProperty(value = MeatContract.COL_NUMBER_BY_PERSON)
    private int numberByPerson;
}
