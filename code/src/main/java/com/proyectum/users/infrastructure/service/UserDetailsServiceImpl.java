package com.proyectum.users.infrastructure.service;

import com.proyectum.users.domain.error.InvalidCredentialsError;
import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.Permission;
import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.model.user.Username;
import com.proyectum.users.domain.repository.user.GetUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final GetUserRepository getUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOpt = getUserRepository.getByUsername(new Username(username));
        var user = userOpt.orElseThrow(InvalidCredentialsError::new);
        var permissionsName = user.getRoles().stream()
                .map(RoleAggregate::getPermissions)
                .flatMap(Set::stream)
                .map(Permission::name)
                .map(Name::value)
                .toList();
        List<GrantedAuthority> authorities = new ArrayList<>();
        permissionsName.forEach(name -> authorities.add(new SimpleGrantedAuthority(name)));
        return JwtUserDetails.builder()
                .username(user.getUsername().value())
                .authorities(authorities)
                .build();
    }
}
