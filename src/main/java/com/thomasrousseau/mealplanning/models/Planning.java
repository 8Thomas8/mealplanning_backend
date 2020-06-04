package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.PlanningContract;
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
@AttributeOverride(name = "id", column = @Column(name = PlanningContract.COL_ID))
public class Planning extends EntityBase {

    /**
     * The name of the planning.
     */
    @JsonProperty(value = PlanningContract.COL_NAME)
    @Column(name = PlanningContract.COL_NAME, nullable = false, length = 50, unique = true)
    private String name;

    /**
     * Days from the association with Day.
     */
    @JsonProperty(value = "slots")
    @OneToMany
    private Collection<Slot> slots;
}
