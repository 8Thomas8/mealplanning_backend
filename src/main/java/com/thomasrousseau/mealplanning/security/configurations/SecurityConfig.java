package com.thomasrousseau.mealplanning.security.configurations;

import com.thomasrousseau.mealplanning.security.AppAuthProvider;
import com.thomasrousseau.mealplanning.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Security config for spring boot.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Api path where there is no verification on CSRF Token.
     */
    private static final String[] CSRF_IGNORE = {"/api/getToken"};

    @Autowired
    UserService userDetailsService;

    /**
     * Configuration for the authentication manager.
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Configuration for spring boot security.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .ignoringAntMatchers(CSRF_IGNORE)
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .exceptionHandling()
                    .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and()
                    .authenticationProvider(getProvider())
                .formLogin()
                    .loginProcessingUrl("/api/login")
                    .successHandler(new AuthentificationLoginSuccessHandler())
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout()
                    .logoutUrl("/api/logout")
                    .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
                    .invalidateHttpSession(true)
                .and()
                    .authorizeRequests()
                    .antMatchers("/api/getToken", "/api/user/register").permitAll()
                    .anyRequest().authenticated();
    }

    /**
     * Login success handler.
     */
    private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            logger.info("Utilisateur connecté" + " || username: " + userDetails.getUsername());
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    /**
     * Logout succes handler.
     */
    private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) {
            if (authentication != null) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                logger.info("Utilisateur déconnecté" + " || username: " + userDetails.getUsername());
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }

    @Bean
    public AuthenticationProvider getProvider() {
        AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;

    }
}
