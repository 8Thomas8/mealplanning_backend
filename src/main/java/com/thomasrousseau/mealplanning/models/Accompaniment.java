package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.AccompanimentContract;
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
public class Accompaniment extends Ingredient {
}
