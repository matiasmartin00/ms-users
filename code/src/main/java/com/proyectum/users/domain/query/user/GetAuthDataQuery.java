package com.proyectum.users.domain.query.user;

import com.proyectum.cqrs.query.Query;

public record GetAuthDataQuery(String username) implements Query {
}
