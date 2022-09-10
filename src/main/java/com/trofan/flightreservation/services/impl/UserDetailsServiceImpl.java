package com.trofan.flightreservation.services.impl;


import com.trofan.flightreservation.entities.User;
import com.trofan.flightreservation.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    public static final String ROLE_SEPARATOR = ";";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for email " + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(getAuthorities(user))
                .build();
    }

    private Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (String role : user.getRoles().split(ROLE_SEPARATOR)) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
