package com.proyectum.users.infrastructure.repository.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permissions")
public class PermissionEntity {

    @Id
    @Column(nullable = false, unique = true, name = "id")
    private UUID id;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(nullable = false, unique = true, name = "description")
    private String description;
}
