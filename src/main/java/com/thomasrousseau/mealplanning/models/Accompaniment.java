package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.AccompanimentContract;
import com.thomasrousseau.mealplanning.database.contracts.DayContract;
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
@Table(name = AccompanimentContract.TABLE)
@ToString
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = AccompanimentContract.COL_ID))
public class Accompaniment extends Ingredient {
}
