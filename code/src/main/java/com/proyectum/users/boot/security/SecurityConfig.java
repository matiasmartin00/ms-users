package com.proyectum.users.boot.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("spring.security")
public class SecurityConfig {

    private List<String> excludesPattern;
}
