CREATE TABLE estoque (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(80) NOT NULL,
quantidade INT,
valor DECIMAL,
id_usuarios  INT,
FOREIGN KEY (id_usuarios) REFERENCES usuarios (id)
);


INSERT INTO estoque (nome, quantidade, valor, id_usuarios) VALUES ('nutella', 6, 12.50, 1);
INSERT INTO estoque (nome, quantidade, valor, id_usuarios) VALUES ('ruffles', 15, 8.20, 1);
INSERT INTO estoque (nome, quantidade, valor, id_usuarios) VALUES ('budwiser', 30, 2.29, 1);