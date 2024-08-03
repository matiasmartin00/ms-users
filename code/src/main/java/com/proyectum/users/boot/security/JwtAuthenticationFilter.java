package com.proyectum.users.boot.security;

import com.proyectum.users.domain.error.InvalidCredentialsError;
import com.proyectum.users.domain.repository.JwtRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final JwtRepository jwtRepository;
    private final UserDetailsService userDetailsService;
    private final SecurityConfig securityConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        boolean isExcluded = securityConfig.getExcludesPattern().stream()
                .anyMatch(pattern -> ANT_PATH_MATCHER.match(pattern, requestURI));

        if (isExcluded) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.isBlank(authorizationHeader)) {
            throw new InvalidCredentialsError();
        }

        if (!authorizationHeader.startsWith(BEARER_PREFIX)) {
            throw new InvalidCredentialsError();
        }

        var jwt = authorizationHeader.substring(BEARER_PREFIX.length());
        jwtRepository.checkToken(jwt);
        var username = jwtRepository.getUsername(jwt);
        var context = SecurityContextHolder.getContext();
        var userDetails = userDetailsService.loadUserByUsername(username);

        var usernameAuthenticationToken = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities()
        );

        context.setAuthentication(usernameAuthenticationToken);
        filterChain.doFilter(request, response);
    }
}
