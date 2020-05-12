package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.DayContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.DayName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Date;

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
    @Column(name = DayContract.COL_DATE, nullable = false)
    @JsonProperty(value = DayContract.COL_DATE)
    private Date date;

    /**
     * Moments from the association with Moment.
     */
    @OneToMany
    @JsonProperty(value = "moments")
    private Collection<Moment> moments;
}
