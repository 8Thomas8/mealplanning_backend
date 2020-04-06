package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.PlanningContract;
import com.thomasrousseau.mealplanning.database.contracts.UserContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

/**
 * Define the User object.
 */
@Entity
@Table(name = UserContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name="id", column = @Column(name = UserContract.COL_ID))
public class User extends EntityBase {

    /**
     * The name of the user.
     */
    @JsonProperty(value = UserContract.COL_NAME)
    @Column(name = UserContract.COL_NAME, nullable = false, length = 50, unique = true)
    private String name;

    /**
     * Email of the user.
     */
    @JsonProperty(value = UserContract.COL_EMAIL)
    @Column(name = UserContract.COL_EMAIL, nullable = false)
    private String email;

    /**
     * Password of the user.
     */
    @JsonProperty(value = UserContract.COL_PASSWORD)
    @Column(name = UserContract.COL_PASSWORD, nullable = false)
    private String password;

    /**
     * Role of the user.
     */
    @JsonProperty(value = UserContract.COL_ROLE)
    @Column(name = UserContract.COL_ROLE)
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    /**
     * Association with a Planning object.
     */
    @OneToMany()
    @JsonProperty(value = "plannings")
    private Collection<Planning> planning;
}
