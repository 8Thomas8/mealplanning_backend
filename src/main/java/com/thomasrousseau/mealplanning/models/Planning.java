package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.PlanningContract;
import com.thomasrousseau.mealplanning.database.contracts.UserContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

/**
 * Define the Planning object.
 */
@Entity
@Table(name = PlanningContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name="id", column = @Column(name = PlanningContract.COL_ID))
public class Planning extends EntityBase {

    /**
     * The name of the planning.
     */
    @Column(name = PlanningContract.COL_NAME, nullable = false, length = 50, unique = true)
    private String name;

    /**
     * User id from the association.
     */
    @ManyToOne
    @JoinColumn(name=PlanningContract.COL_USER_ID)
    private User user;

    /**
     * Days from the association with Day.
     */
    @ManyToMany
    private Collection<Day> days;
}
