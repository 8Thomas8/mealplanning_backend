package com.thomasrousseau.mealplanning.security.services;

import com.thomasrousseau.mealplanning.database.repositories.UserRepository;
import com.thomasrousseau.mealplanning.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        return user;
    }

    public Boolean comparePassword(String passwordAuth, String passwordBase) {
        return passwordAuth.equals(passwordBase);
    }
}
