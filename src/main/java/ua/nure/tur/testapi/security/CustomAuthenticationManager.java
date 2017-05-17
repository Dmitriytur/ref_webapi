package ua.nure.tur.testapi.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import ua.nure.tur.testapi.entities.User;
import ua.nure.tur.testapi.domain.UserService;

import java.util.Collections;

public class CustomAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserService userService = new UserService();

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userService.findUserByUsername(username);

        if (user == null) {
            throw new BadCredentialsException("Username not found.");
        }

        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }
        return new UsernamePasswordAuthenticationToken(user.getId(), user.getRole(), Collections.emptyList());
    }
}
