INSERT INTO users(username,password,enabled)
VALUES ('he','123456', true);
INSERT INTO users(username,password,enabled)
VALUES ('zhang','123456', true);

INSERT INTO user_roles (username, role)
VALUES ('he', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('he', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('zhang', 'ROLE_USER');