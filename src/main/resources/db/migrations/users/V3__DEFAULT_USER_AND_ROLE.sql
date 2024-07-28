INSERT INTO users (id, username, email, password_hash, created_at, updated_at)
VALUES ('66a822be-b28a-4258-9a51-f6bd017ba0fe', 'admin', 'admin@proyectum.com',
        '$2a$10$Px1c9RDsyqI3t5dnU55wP.F4Wzoqjt2WK9.9QM51mJT6m3KbPyT9G', '2024-07-28 19:00:04.259846',
        '2024-07-28 19:00:04.259868');

INSERT INTO roles (id, name, description)
VALUES ('fde0142f-a80a-4b0e-9867-896e9ae03f16', 'admin', 'admin role');

INSERT INTO permissions (id, name, description)
VALUES ('f2ed6fc7-f5ba-4388-a795-d037b69a0476', 'admin', 'admin permissions');

INSERT INTO role_permissions (id, role_id, permission_id)
VALUES ('8da060b7-b641-4d8d-b031-f7b26040b1ed', 'fde0142f-a80a-4b0e-9867-896e9ae03f16', 'f2ed6fc7-f5ba-4388-a795-d037b69a0476');

INSERT INTO user_roles (id, user_id, role_id)
VALUES ('378c2539-bb32-4e26-b0fb-f750e3e2ad1e','66a822be-b28a-4258-9a51-f6bd017ba0fe', 'fde0142f-a80a-4b0e-9867-896e9ae03f16')