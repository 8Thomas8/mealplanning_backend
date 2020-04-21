package com.thomasrousseau.mealplanning.security.services;

import com.thomasrousseau.mealplanning.database.repositories.UserRepository;
import com.thomasrousseau.mealplanning.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * User service, for getting details of the logged user and to compare credientials with the database.
 */
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Return user details.
     * @param username is the username from the user search.
     * @return return details form the user.
     */
    @Override
    public UserDetails loadUserByUsername(String username) {

        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        return user;
    }

    /**
     * Compare the user password from the request with the passwird in the databse.
     * @param passwordAuth is the password from the client.
     * @param passwordBase is the password in the database.
     * @return a boolean wich is true if password match.
     */
    public Boolean comparePassword(String passwordAuth, String passwordBase) {
        return passwordAuth.equals(passwordBase);
    }
}
