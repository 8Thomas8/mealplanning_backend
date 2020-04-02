package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.DayContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.DayName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Define the Planning object.
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
    @Column(name = DayContract.COL_NAME, nullable = false, length = 50, unique = true)
    private DayName name;
}
