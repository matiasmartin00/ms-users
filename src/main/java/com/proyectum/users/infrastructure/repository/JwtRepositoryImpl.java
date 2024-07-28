package com.proyectum.users.infrastructure.repository;

import com.proyectum.users.domain.error.InvalidCredentialsError;
import com.proyectum.users.domain.model.UserAggregate;
import com.proyectum.users.domain.repository.JwtRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JwtRepositoryImpl implements JwtRepository {

    @Value("${spring.security.jwt.secret}")
    private String secret;

    @Value("${spring.security.jwt.expiration}")
    private Integer expiration;

    @Override
    public String generateToken(UserAggregate user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername().value())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    @Override
    public void checkToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
        } catch (JwtException | IllegalArgumentException e) {
            log.error("Invalid JWT token", e);
            throw new InvalidCredentialsError();
        }
    }
}
