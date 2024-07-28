package com.proyectum.users.infrastructure.service;

import com.proyectum.users.domain.error.InvalidCredentialsError;
import com.proyectum.users.domain.model.user.Username;
import com.proyectum.users.domain.repository.user.GetUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final GetUserRepository getUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOpt = getUserRepository.getByUsername(new Username(username));
        var user = userOpt.orElseThrow(InvalidCredentialsError::new);
        return JwtUserDetails.builder()
                .username(user.getUsername().value())
                .authorities(List.of(new SimpleGrantedAuthority("admin")))
                .build();
    }
}
