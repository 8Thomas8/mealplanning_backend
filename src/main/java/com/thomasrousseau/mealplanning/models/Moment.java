package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.DayContract;
import com.thomasrousseau.mealplanning.database.contracts.MomentContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.DayName;
import com.thomasrousseau.mealplanning.models.enumerations.MomentName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Define the Moment object.
 */
@Entity
@Table(name = MomentContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = MomentContract.COL_ID))
public class Moment extends EntityBase {

    /**
     * The name of the Moment.
     */
    @Column(name = MomentContract.COL_NAME, nullable = false, length = 50, unique = true)
    private MomentName name;

    /**
     * The guest number of the Moment.
     */
    @Column(name = MomentContract.COL_GUEST_NUMBER, nullable = false)
    private int guestNumber;
}
