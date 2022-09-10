package com.trofan.flightreservation.services.impl;

import com.trofan.flightreservation.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    public boolean login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
                userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        boolean result = token.isAuthenticated();
        if (result) {
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return result;
    }

}
