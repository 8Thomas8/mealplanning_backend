package com.thomasrousseau.mealplanning.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thomasrousseau.mealplanning.database.contracts.UserContract;
import com.thomasrousseau.mealplanning.models.base.EntityBase;
import com.thomasrousseau.mealplanning.models.enumerations.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Define the User object.
 */
@Entity
@Table(name = UserContract.TABLE)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@AttributeOverride(name="id", column = @Column(name = UserContract.COL_ID))
public class User extends EntityBase implements Serializable, UserDetails {

    /**
     * The name of the user.
     */
    @JsonProperty(value = UserContract.COL_USERNAME)
    @Column(name = UserContract.COL_USERNAME, nullable = false, length = 50, unique = true)
    private String username;

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
    @JsonIgnore
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
    @OneToMany(fetch = FetchType.EAGER)
    @JsonProperty(value = "plannings")
    private Collection<Planning> planning;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
