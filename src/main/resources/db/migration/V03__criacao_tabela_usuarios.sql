CREATE TABLE usuarios (
id INT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(80) NOT NULL,
senha VARCHAR(80) NOT NULL,
perfil_id INT,
FOREIGN KEY (perfil_id) REFERENCES perfis(id)
);

INSERT INTO usuarios (email, senha, perfil_id) VALUES ('admin@email.com', '$2a$10$H0PrspgFFgvsI9dMyqpvt.n6TjKQhtSmlYo9YACXnm4dX1Zbhbyq.', 1);
INSERT INTO usuarios (email, senha, perfil_id) VALUES ('user@email.com', '$2a$10$H0PrspgFFgvsI9dMyqpvt.n6TjKQhtSmlYo9YACXnm4dX1Zbhbyq.', 2);