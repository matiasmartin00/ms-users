package com.proyectum.users.domain.query.user;

import com.proyectum.users.ddd.query.Query;

public record GetAuthDataQuery(String username) implements Query {
}
