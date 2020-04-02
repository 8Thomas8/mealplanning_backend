package com.thomasrousseau.mealplanning.models;

import com.thomasrousseau.mealplanning.database.contracts.UserContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.UserRole;
import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    @Column(name = UserContract.COL_NAME, nullable = false, length = 50, unique = true)
    private String name;

    /**
     * Email of the user.
     */
    @Column(name = UserContract.COL_EMAIL, nullable = false)
    private String email;

    /**
     * Password of the user.
     */
    @Column(name = UserContract.COL_PASSWORD, nullable = false)
    private String password;

    /**
     * Role of the user.
     */
    @Column(name = UserContract.COL_ROLE)
    private UserRole role = UserRole.USER;
}
