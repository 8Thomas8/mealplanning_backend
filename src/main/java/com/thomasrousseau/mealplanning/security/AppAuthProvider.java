package com.thomasrousseau.mealplanning.security;

import com.thomasrousseau.mealplanning.security.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {
    @Autowired
    UserService userDetailsService;

    private static Logger logger = LoggerFactory.getLogger(AppAuthProvider.class);


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

        String name = auth.getName();
        String password = auth.getCredentials()
                .toString();
        UserDetails user = userDetailsService.loadUserByUsername(name);

        if (userDetailsService.comparePassword(password, user.getPassword()) ) {
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }

        logger.info("Erreur de connexion" + " || username: " + user.getUsername());

        throw new BadCredentialsException("Information de connexion erronées");
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
