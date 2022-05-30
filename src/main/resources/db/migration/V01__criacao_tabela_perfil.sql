CREATE TABLE perfis (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(80) NOT NULL
);

INSERT INTO perfis (nome) VALUES ('Admin');
INSERT INTO perfis (nome) VALUES ('Usuario');