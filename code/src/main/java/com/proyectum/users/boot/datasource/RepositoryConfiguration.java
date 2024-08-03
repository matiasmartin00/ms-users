package com.proyectum.users.boot.datasource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.proyectum.users.infrastructure.repository.postgres.entity")
@EnableJpaRepositories(basePackages = "com.proyectum.users.infrastructure.repository.postgres.repository")
public class RepositoryConfiguration {
}
